package dev.pichborith.ItemManagement.repositories;

import dev.pichborith.ItemManagement.models.Inventory;
import dev.pichborith.ItemManagement.models.Item.InventoryDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface InventoryRepository extends JpaRepository<Inventory, Integer> {

    @Query(value = "SELECT l.location_id AS location_id, l.type AS type, inv.quantity AS quantity FROM inventories AS inv JOIN locations AS l ON inv.location_id = l.location_id WHERE inv.item_id= ?", nativeQuery = true)
    Set<InventoryDTO> findAllByItemId(int itemId);
}
