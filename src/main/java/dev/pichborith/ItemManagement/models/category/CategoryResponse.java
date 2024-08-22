package dev.pichborith.ItemManagement.models.category;

import dev.pichborith.ItemManagement.models.item.Item;

import java.util.List;
import java.util.Set;

public record CategoryResponse(
    int id,
    String name,
    List<CategoryItem> items
) {
}
