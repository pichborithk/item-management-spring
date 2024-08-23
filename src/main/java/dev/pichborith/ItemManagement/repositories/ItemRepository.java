package dev.pichborith.ItemManagement.repositories;

import dev.pichborith.ItemManagement.models.item.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Integer> {

    @Query("SELECT i FROM Item i JOIN FETCH i.category")
    List<Item> findAllWithCategory();

    @Query("SELECT i FROM Item i JOIN FETCH i.category WHERE i.id = ?1")
    Item findByIdAllWithCategory(int itemId);

    List<Item> findAllByCategoryId(int categoryId);

    @Modifying
    @Query("DELETE FROM Item i WHERE i.id = :itemId")
    void deleteById(int itemId);
}
