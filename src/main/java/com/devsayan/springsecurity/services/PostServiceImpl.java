package com.devsayan.springsecurity.services;

import com.devsayan.springsecurity.dtos.PostDto;
import com.devsayan.springsecurity.entities.PostEntity;
import com.devsayan.springsecurity.exceptions.ResourceNotFoundException;
import com.devsayan.springsecurity.repositories.PostRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService{
    private final ModelMapper modelMapper;
    private final PostRepository postRepository;
    @Override
    public List<PostDto> getAllPosts() {
        List<PostEntity> posts = postRepository.findAll();
        return posts
                .stream()
                .map(postEntity ->
                        modelMapper
                        .map(postEntity,PostDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public PostDto createPost(PostDto postDto) {
        PostEntity postEntity = modelMapper.map(postDto, PostEntity.class);
        PostEntity savedPostEntity = postRepository.save(postEntity);
        return modelMapper.map(savedPostEntity,PostDto.class);
    }

    @Override
    public PostDto getPostById(Long id) {
      PostEntity post = postRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("resource unavailable"));
      return modelMapper.map(post,PostDto.class);

    }
}
