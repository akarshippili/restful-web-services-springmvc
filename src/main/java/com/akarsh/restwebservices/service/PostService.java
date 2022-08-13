package com.akarsh.restwebservices.service;

import com.akarsh.restwebservices.dao.entity.Post;
import com.akarsh.restwebservices.dao.repo.PostRepo;
import com.akarsh.restwebservices.dto.PostDto;
import com.akarsh.restwebservices.dto.UserDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {

    @Autowired
    private PostRepo postRepo;

    @Autowired
    private ModelMapper mapper;


    public List<PostDto> getPostsByUser(long userId){
        List<Post> postList =  postRepo.getPostsByUserId(userId);
        return postList.stream()
                .map(post -> mapper.map(post, PostDto.class))
                .collect(Collectors.toList());
    }

}
