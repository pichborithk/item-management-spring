package dev.pichborith.ItemManagement.services;

import dev.pichborith.ItemManagement.models.category.CategoryRequest;
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
        var categories = categoryRepository.findAll();
        List<CategoryResponse> response = new ArrayList<>();

        for (var category : categories) {
            var items = itemRepository.findAllByCategoryId(category.getId());
            var categoryResponse = categoryMapper.toCategoryResponse(category,
                                                                     items);
            response.add(categoryResponse);
        }
        return response;
    }

    public CategoryResponse add(CategoryRequest request) {
        var category = categoryRepository.save(categoryMapper
                                                   .toCategory(request));
        return categoryMapper.toCategoryResponse(category);
    }
}
