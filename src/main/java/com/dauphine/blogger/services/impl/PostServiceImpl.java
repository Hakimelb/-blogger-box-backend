package com.dauphine.blogger.services.impl;

import com.dauphine.blogger.models.Post;
import com.dauphine.blogger.services.PostService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class PostServiceImpl implements PostService {

    private final List<Post> temporaryPosts;

    public PostServiceImpl() {
        temporaryPosts = new ArrayList<>();
        UUID cat1 = UUID.randomUUID();
        UUID cat2 = UUID.randomUUID();
        temporaryPosts.add(new Post(UUID.randomUUID(), "my first post", "first content", cat1));
        temporaryPosts.add(new Post(UUID.randomUUID(), "my second post", "second content", cat2));
        temporaryPosts.add(new Post(UUID.randomUUID(), "my third post", "third content", cat1));
    }

    @Override
    public List<Post> getAllByCategoryId(UUID categoryId) {
        List<Post> result = new ArrayList<>();
        for (Post post : temporaryPosts) {
            if (categoryId.equals(post.getCategoryId())) {
                result.add(post);
            }
        }
        return result;
    }

    @Override
    public List<Post> getAll() {
        return temporaryPosts;
    }

    @Override
    public Post getById(UUID id) {
        return temporaryPosts.stream()
                .filter(post -> id.equals(post.getId()))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Post create(String title, String content, UUID categoryId) {
        Post post = new Post(UUID.randomUUID(), title, content, categoryId);
        temporaryPosts.add(post);
        return post;
    }

    @Override
    public Post update(UUID id, String title, String content) {
        Post post = getById(id);
        if (post != null) {
            post.setTitle(title);
            post.setContent(content);
        }
        return post;
    }

    @Override
    public boolean deleteById(UUID id) {
        return temporaryPosts.removeIf(post -> id.equals(post.getId()));
    }
}