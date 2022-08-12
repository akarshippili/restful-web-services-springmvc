package com.akarsh.restwebservices.service;

import com.akarsh.restwebservices.dao.entity.User;
import com.akarsh.restwebservices.dao.repo.UserRepo;
import com.akarsh.restwebservices.dto.UserDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
           throw new Exception("User with Id not found");
        }
    }

}
