package dev.pichborith.ItemManagement.repositories;

import dev.pichborith.ItemManagement.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Integer> {

    @Query("SELECT i FROM Item i JOIN FETCH i.category")
    List<Item> findAllWithCategory();
}
