package com.dauphine.blogger.controllers;

import com.dauphine.blogger.services.PostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@Tag(
        name = "Posts API",
        description = "Endpoints for posts"
)
@RestController
@RequestMapping("/v1/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    @Operation(summary = "Create a new post")
    public String createPost() {
        return postService.createPost();
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an existing post")
    public String updatePost(
            @Parameter(description = "Post id")
            @PathVariable Long id
    ) {
        return postService.updatePost(id);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete an existing post")
    public String deletePost(
            @Parameter(description = "Post id")
            @PathVariable Long id
    ) {
        return postService.deletePost(id);
    }

    @GetMapping
    @Operation(summary = "Retrieve all posts ordered by creation date")
    public String getAllPosts() {
        return postService.getAllPosts();
    }

    @GetMapping("/by-category/{categoryId}")
    @Operation(summary = "Retrieve all posts per a category")
    public String getPostsByCategory(
            @Parameter(description = "Category id")
            @PathVariable Long categoryId
    ) {
        return postService.getPostsByCategory(categoryId);
    }
}