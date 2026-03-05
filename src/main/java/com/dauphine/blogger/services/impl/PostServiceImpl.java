package com.dauphine.blogger.services.impl;

import com.dauphine.blogger.models.Category;
import com.dauphine.blogger.models.Post;
import com.dauphine.blogger.repositories.CategoryRepository;
import com.dauphine.blogger.repositories.PostRepository;
import com.dauphine.blogger.services.PostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository repository;
    private final CategoryRepository categoryRepository;

    public PostServiceImpl(PostRepository repository, CategoryRepository categoryRepository) {
        this.repository = repository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Post> getAll() {
        return repository.findAll();
    }

    @Override
    public List<Post> getAllByValue(String value) {
        return repository.findAllLikeValue(value);
    }

    @Override
    public Post getById(UUID id) {
        return repository.findById(id).orElseThrow(() -> new com.dauphine.blogger.exceptions.PostNotFoundException(id));
    }

    @Override
    public Post create(String title, String content, UUID categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new com.dauphine.blogger.exceptions.CategoryNotFoundException(categoryId));
        Post post = new Post(title, content, category);
        return repository.save(post);
        }

    @Override
    public Post updateContent(UUID id, String content) {
        Post post = getById(id);
        post.setContent(content);
        return repository.save(post);
    }

    @Override
    public boolean deleteById(UUID id) {
        repository.deleteById(id);
        return true;
    }
}