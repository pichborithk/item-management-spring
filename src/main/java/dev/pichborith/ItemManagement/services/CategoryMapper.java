package dev.pichborith.ItemManagement.services;

import dev.pichborith.ItemManagement.models.category.Category;
import dev.pichborith.ItemManagement.models.category.CategoryItem;
import dev.pichborith.ItemManagement.models.category.CategoryResponse;
import dev.pichborith.ItemManagement.models.item.Item;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryMapper {

    public CategoryResponse toCategoryResponse(Category category, List<Item> items) {
        List<CategoryItem> categoryItems = new ArrayList<>();
        for (var item : items) {
            var categoryItem = new CategoryItem(item.getId(), item.getName(),
                                                item.getPrice());
            categoryItems.add(categoryItem);
        }
        return new CategoryResponse(category.getId(), category.getName(),
                                    categoryItems);
    }
}
