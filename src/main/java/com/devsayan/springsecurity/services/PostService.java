package com.devsayan.springsecurity.services;

import com.devsayan.springsecurity.dtos.PostDto;

import java.util.List;

public interface PostService {

    public List<PostDto> getAllPosts();
    public PostDto createPost(PostDto postDto);
    public PostDto getPostById(Long id);
}
