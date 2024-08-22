package dev.pichborith.ItemManagement.models.category;


import java.util.List;

public record CategoryResponse(
    int id,
    String name,
    List<CategoryItem> items
) {
}
