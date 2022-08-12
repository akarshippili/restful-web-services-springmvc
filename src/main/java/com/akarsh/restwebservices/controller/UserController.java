package com.akarsh.restwebservices.controller;

import com.akarsh.restwebservices.dto.UserDto;
import com.akarsh.restwebservices.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(path = "/users/{id}")
    public UserDto getUserById(@PathVariable long id) throws Exception {
        return userService.getUserById(id);
    }

}
