package com.dauphine.blogger.controllers;

import com.dauphine.blogger.models.Post;
import com.dauphine.blogger.services.PostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(
        name = "Posts API",
        description = "Endpoints for posts"
)
@RestController
@RequestMapping("/v1/posts")
public class PostController {

    private final PostService service;

    public PostController(PostService service) {
        this.service = service;
    }

    @GetMapping("/by-category/{categoryId}")
    @Operation(summary = "Retrieve all posts per a category")
    public List<Post> getAllByCategory(
            @Parameter(description = "Category id")
            @PathVariable UUID categoryId
    ) {
        return service.getAllByCategoryId(categoryId);
    }

    @GetMapping
    @Operation(summary = "Retrieve all posts ordered by creation date")
    public List<Post> getAllPosts() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Retrieve a post by id")
    public Post getPostById(
            @Parameter(description = "Post id")
            @PathVariable UUID id
    ) {
        return service.getById(id);
    }

    @PostMapping
    @Operation(summary = "Create a new post")
    public Post createPost(@RequestBody Post post) {
        return service.create(post.getTitle(), post.getContent(), post.getCategoryId());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an existing post")
    public Post updatePost(
            @Parameter(description = "Post id")
            @PathVariable UUID id,
            @RequestBody Post post
    ) {
        return service.update(id, post.getTitle(), post.getContent());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete an existing post")
    public boolean deletePost(
            @Parameter(description = "Post id")
            @PathVariable UUID id
    ) {
        return service.deleteById(id);
    }
}