package com.devsayan.springsecurity.controllers;


import com.devsayan.springsecurity.dtos.PostDto;
import com.devsayan.springsecurity.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping
    public ResponseEntity<List<PostDto>> getAllPosts(){
        return  ResponseEntity.ok(postService.getAllPosts());
    }
    @PostMapping(path = "/createPost")
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto){
        return new ResponseEntity<>(postService.createPost(postDto), HttpStatus.CREATED);
    }
    @GetMapping(path = "/byId/{id}")
    public ResponseEntity<PostDto> getPostById(Long id){
        return new ResponseEntity<>(postService.getPostById(id),HttpStatus.FOUND);
    }

}
