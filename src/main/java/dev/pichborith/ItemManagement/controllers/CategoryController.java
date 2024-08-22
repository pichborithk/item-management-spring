package dev.pichborith.ItemManagement.controllers;

import dev.pichborith.ItemManagement.models.category.CategoryRequest;
import dev.pichborith.ItemManagement.models.category.CategoryResponse;
import dev.pichborith.ItemManagement.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<CategoryResponse>> getAllCategories() {
        var response = categoryService.getAll();
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<CategoryResponse> createCategory(@RequestBody
                                                           CategoryRequest request) {
        var response = categoryService.add(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
