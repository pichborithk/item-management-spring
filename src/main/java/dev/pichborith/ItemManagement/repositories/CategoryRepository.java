package dev.pichborith.ItemManagement.repositories;

import dev.pichborith.ItemManagement.models.category.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
