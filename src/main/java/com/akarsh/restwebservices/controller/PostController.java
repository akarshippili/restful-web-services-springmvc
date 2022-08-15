package com.akarsh.restwebservices.controller;

import com.akarsh.restwebservices.dto.PostDto;
import com.akarsh.restwebservices.dto.UserDto;
import com.akarsh.restwebservices.exception.custom.UserNotFoundException;
import com.akarsh.restwebservices.service.PostService;
import com.akarsh.restwebservices.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1")
public class PostController {

    @Autowired
    private UserService userService;

    @Autowired
    private PostService postService;


    @GetMapping(path = "/users/{id}/posts")
    public List<PostDto> getPostByUser(@PathVariable("id") long id){
        if(!userService.isValidUser(id)) throw new UserNotFoundException("user Not Found");
        return postService.getPostsByUser(id);
    }

    @GetMapping(path = "/users/{id}/posts/{postId}")
    public PostDto getPostByPostId(@PathVariable("id") long id, @PathVariable("postId") long postId){
        return postService.getPostByPostId(id, postId);
    }

    @PostMapping(path = "/users/{id}/posts")
    public ResponseEntity<PostDto> createPost(@PathVariable long id, @Valid @RequestBody PostDto postDto){
        PostDto savedPost = postService.createPost(id, postDto);
        return new ResponseEntity<>(savedPost, HttpStatus.CREATED);
    }


}
