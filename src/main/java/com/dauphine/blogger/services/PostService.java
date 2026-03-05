package com.dauphine.blogger.services;

import com.dauphine.blogger.models.Post;

import java.util.List;
import java.util.UUID;

public interface PostService {

    List<Post> getAll();

    List<Post> getAllByValue(String value);

    Post getById(UUID id);

    Post create(String title, String content, UUID categoryId);

    Post updateContent(UUID id, String content);

    boolean deleteById(UUID id);
}