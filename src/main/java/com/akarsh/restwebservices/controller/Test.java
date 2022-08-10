package com.akarsh.restwebservices.controller;

import com.akarsh.restwebservices.dto.HelloWorldBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1")
public class Test {

    @GetMapping(path = "/hello-world")
    public String test(){
        return "Hello World!!!";
    }

    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("Hi");
    }

    @GetMapping(path = "/hello-world/{message}")
    public HelloWorldBean helloWorldBeanWithmsg(@PathVariable String message){
        return new HelloWorldBean("hello world, and hi " + message);
    }

}