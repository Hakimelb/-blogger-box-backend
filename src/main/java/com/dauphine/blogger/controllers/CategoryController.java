package com.dauphine.blogger.controllers;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@Tag(
        name = "Categories API",
        description = "Endpoints for categories"
)
@RestController
@RequestMapping("/v1/categories")
public class CategoryController {

    @GetMapping
    @Operation(summary = "Retrieve all categories")
    public String getAllCategories() {
        return "Not implemented";
    }

    @GetMapping("/{id}")
    @Operation(summary = "Retrieve a category by id")
    public String getCategoryById(
            @Parameter(description = "Category id")
            @PathVariable Long id
    ) {
        return "Not implemented";
    }

    @PostMapping
    @Operation(summary = "Create a new category")
    public String createCategory() {
        return "Not implemented";
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update the name of a category")
    public String updateCategoryName(
            @Parameter(description = "Category id")
            @PathVariable Long id
    ) {
        return "Not implemented";
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete an existing category")
    public String deleteCategory(
            @Parameter(description = "Category id")
            @PathVariable Long id
    ) {
        return "Not implemented";
    }
}

