package dev.pichborith.ItemManagement.repositories;

import dev.pichborith.ItemManagement.models.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Integer> {
}
