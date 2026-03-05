package com.dauphine.blogger.controllers;

import com.dauphine.blogger.models.Category;
import com.dauphine.blogger.services.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/categories")
public class CategoryController {

    private final CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Category>> getAll(@RequestParam(required = false) String name) {
        if (name != null) {
            return ResponseEntity.ok(service.getAllByName(name));
        }
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping
    public ResponseEntity<Category> create(@RequestParam String name) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(name));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> updateName(@PathVariable UUID id, @RequestParam String name) {
        return ResponseEntity.ok(service.updateName(id, name));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable UUID id) {
        return ResponseEntity.ok(service.deleteById(id));
    }
}