package com.dauphine.blogger.controllers;

import com.dauphine.blogger.models.Category;
import com.dauphine.blogger.services.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(
        name = "Categories API",
        description = "Endpoints for categories"
)
@RestController
@RequestMapping("/v1/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    @Operation(summary = "Retrieve all categories")
    public List<Category> getAllCategories() {
        return categoryService.getAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Retrieve a category by id")
    public Category getCategoryById(
            @Parameter(description = "Category id")
            @PathVariable UUID id
    ) {
        return categoryService.getById(id);
    }

    @PostMapping
    @Operation(summary = "Create a new category")
    public Category createCategory(
            @Parameter(description = "Category name")
            @RequestParam String name
    ) {
        return categoryService.create(name);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update the name of a category")
    public Category updateCategoryName(
            @Parameter(description = "Category id")
            @PathVariable UUID id,
            @Parameter(description = "New category name")
            @RequestParam String name
    ) {
        return categoryService.updateName(id, name);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete an existing category")
    public void deleteCategory(
            @Parameter(description = "Category id")
            @PathVariable UUID id
    ) {
        categoryService.deleteById(id);
    }
}