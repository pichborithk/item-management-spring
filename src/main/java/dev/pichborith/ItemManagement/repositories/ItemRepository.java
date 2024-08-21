package dev.pichborith.ItemManagement.repositories;

import dev.pichborith.ItemManagement.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer> {
}
