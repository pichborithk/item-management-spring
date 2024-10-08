package dev.pichborith.ItemManagement.repositories;

import dev.pichborith.ItemManagement.models.Inventory;
import dev.pichborith.ItemManagement.models.item.ItemInventory;
import dev.pichborith.ItemManagement.models.location.LocationInventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface InventoryRepository extends JpaRepository<Inventory, Integer> {

    @Query(value = """
        SELECT l.location_id AS location_id, l.type AS type, inv.quantity AS quantity
        FROM inventories AS inv
        JOIN locations AS l ON inv.location_id = l.location_id
        WHERE inv.item_id= ?
        """, nativeQuery = true)
    List<ItemInventory> findAllByItemId(int itemId);

    @Query(value = """
        SELECT i.item_id AS item_id, i.name AS name, i.price AS price, inv.quantity AS quantity
        FROM inventories AS inv
        JOIN items AS i ON inv.item_id = i.item_id
        WHERE inv.location_id = ?
        """, nativeQuery = true)
    List<LocationInventory> findAllByLocationId(int locationId);

    boolean existsByItemIdAndLocationId(int itemId, int locationId);

    @Modifying
    @Transactional
    @Query(value = """
        INSERT INTO inventories (item_id, location_id, quantity)
        VALUES (:itemId , :locationId, :quantity)
        """, nativeQuery = true)
    void addItemToInventory(int itemId, int locationId, int quantity);

    @Modifying
    @Transactional
    @Query(value = """
        UPDATE inventories SET quantity = quantity + :quantity
        WHERE item_id = :itemId AND location_id = :locationId
        """, nativeQuery = true)
    void updateItemQuantityInInventory(int itemId, int locationId, int quantity);
}
