package com.dauphine.blogger.controllers;

import com.dauphine.blogger.models.Post;
import com.dauphine.blogger.services.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/posts")
public class PostController {

    private final PostService service;

    public PostController(PostService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Post>> getAll(@RequestParam(required = false) String value) {
        if (value != null) {
            return ResponseEntity.ok(service.getAllByValue(value));
        }
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping
    public ResponseEntity<Post> create(@RequestParam String title, @RequestParam String content, @RequestParam UUID categoryId) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(title, content, categoryId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Post> updateContent(@PathVariable UUID id, @RequestParam String content) {
        return ResponseEntity.ok(service.updateContent(id, content));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable UUID id) {
        return ResponseEntity.ok(service.deleteById(id));
    }
}