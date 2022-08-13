package com.akarsh.restwebservices.controller;

import com.akarsh.restwebservices.dto.UserDto;
import com.akarsh.restwebservices.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping(path = "/users")
    public ResponseEntity<Object> save(@Valid @RequestBody UserDto userDto){
        UserDto savedUser = userService.save(userDto);
        URI uri =  ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping(path = "/users")
    public List<UserDto> getAllUsers(){
        return userService.getAllUsers();
    }


    @GetMapping(path = "/users/{id}")
    public UserDto getUserById(@PathVariable long id) throws Exception {
        return userService.getUserById(id);
    }

}
