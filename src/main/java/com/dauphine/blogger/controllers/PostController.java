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

    @PostMapping
    @Operation(summary = "Create a new post")
    public String createPost() {
        return "Not implemented";
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an existing post")
    public String updatePost(
            @Parameter(description = "Post id")
            @PathVariable Long id
    ) {
        return "Not implemented";
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete an existing post")
    public String deletePost(
            @Parameter(description = "Post id")
            @PathVariable Long id
    ) {
        return "Not implemented";
    }

    @GetMapping
    @Operation(summary = "Retrieve all posts ordered by creation date")
    public String getAllPosts() {
        return "Not implemented";
    }

    @GetMapping("/by-category/{categoryId}")
    @Operation(summary = "Retrieve all posts per a category")
    public String getPostsByCategory(
            @Parameter(description = "Category id")
            @PathVariable Long categoryId
    ) {
        return "Not implemented";
    }
}