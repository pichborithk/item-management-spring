package dev.pichborith.ItemManagement.services;

import dev.pichborith.ItemManagement.models.category.Category;
import dev.pichborith.ItemManagement.models.category.CategoryResponse;
import dev.pichborith.ItemManagement.repositories.CategoryRepository;
import dev.pichborith.ItemManagement.repositories.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;
    private final ItemRepository itemRepository;

    public List<CategoryResponse> getAll() {
        List<Category> categories = categoryRepository.findAll();
        List<CategoryResponse> categoryResponses = new ArrayList<>();

        for (var category : categories) {
            var items = itemRepository.findAllByCategoryId(category.getId());
            var categoryResponse = categoryMapper.toCategoryResponse(category, items);
            categoryResponses.add(categoryResponse);
        }
        return categoryResponses;
    }
}
