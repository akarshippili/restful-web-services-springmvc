package com.akarsh.restwebservices.service;

import com.akarsh.restwebservices.dao.entity.Post;
import com.akarsh.restwebservices.dao.entity.User;
import com.akarsh.restwebservices.dao.repo.PostRepo;
import com.akarsh.restwebservices.dto.PostDto;
import com.akarsh.restwebservices.dto.UserDto;
import com.akarsh.restwebservices.exception.custom.ForbiddenException;
import com.akarsh.restwebservices.exception.custom.UserNotFoundException;
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

    @Autowired
    private UserService userService;


    public List<PostDto> getPostsByUser(long userId){
        List<Post> postList =  postRepo.getPostsByUserId(userId);
        return postList.stream()
                .map(post -> mapper.map(post, PostDto.class))
                .collect(Collectors.toList());
    }

    public PostDto getPostByPostId(long userId, long postId){
        if(!userService.isValidUser(userId)) throw new UserNotFoundException(String.format("User with id %s Not Found",userId));
        Post post =  postRepo.getPostById(postId);
        if(post.getUser().getId()!=userId) throw new ForbiddenException("Forbidden Resource");
        return mapper.map(post,PostDto.class);
    }

    public PostDto createPost(long userId, PostDto postDto) {
        UserDto userDto = userService.getUserById(userId);

        Post post = mapper.map(postDto, Post.class);
        post.setUser(mapper.map(userDto, User.class));

        Post savedPost = postRepo.save(post);
        return mapper.map(savedPost,PostDto.class);
    }
}
