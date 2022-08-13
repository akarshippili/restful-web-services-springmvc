package com.akarsh.restwebservices.service;

import com.akarsh.restwebservices.dao.entity.User;
import com.akarsh.restwebservices.dao.repo.UserRepo;
import com.akarsh.restwebservices.dto.UserDto;
import com.akarsh.restwebservices.exception.custom.UserNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper mapper;


    public UserDto getUserById(long id) throws Exception{
        Optional<User> optionalUser = userRepo.getUserById(id);
        if(optionalUser.isPresent()){
            System.out.println(optionalUser.get());
            return mapper.map(optionalUser.get(), UserDto.class);
        } else {
           throw new UserNotFoundException("User with Id not found");
        }
    }

    public UserDto save(UserDto userDto){
        User user1 = userRepo.save(mapper.map(userDto,User.class));
        return mapper.map(user1, UserDto.class);
    }

    public List<UserDto> getAllUsers() {
        List<User> users = userRepo.findAll();
        return users.stream().map(
                user -> mapper.map(user,UserDto.class)
        ).collect(Collectors.toList());
    }
}
