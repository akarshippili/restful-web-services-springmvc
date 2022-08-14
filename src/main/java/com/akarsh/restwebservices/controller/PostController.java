package com.akarsh.restwebservices.controller;

import com.akarsh.restwebservices.dto.PostDto;
import com.akarsh.restwebservices.dto.UserDto;
import com.akarsh.restwebservices.service.PostService;
import com.akarsh.restwebservices.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
        UserDto user = userService.getUserById(id);
        return postService.getPostsByUser(user.getId());
    }

    @GetMapping(path = "/users/{id}/posts/{postId}")
    public PostDto getPostByPostId(@PathVariable("id") long id, @PathVariable("postId") long postId){
        return postService.getPostByPostId(id, postId);
    }

    @PostMapping(path = "/users/{id}/posts")
    public PostDto createPost(@PathVariable long id, @Valid @RequestBody PostDto postDto){
        return postService.createPost(id, postDto);
    }


}
