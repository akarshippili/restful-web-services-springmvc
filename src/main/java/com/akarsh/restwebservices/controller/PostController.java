package com.akarsh.restwebservices.controller;

import com.akarsh.restwebservices.dto.PostDto;
import com.akarsh.restwebservices.dto.UserDto;
import com.akarsh.restwebservices.service.PostService;
import com.akarsh.restwebservices.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        System.out.println(id);
        UserDto user = userService.getUserById(id);
        return postService.getPostsByUser(user.getId());
    }


}
