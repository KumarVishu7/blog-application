package com.Blog_Project.Services.impl;

import com.Blog_Project.Entities.User;
import com.Blog_Project.Exception.ResourceNotFoundException;
import com.Blog_Project.Repositories.UserRepo;
import com.Blog_Project.Services.UserService;
import com.Blog_Project.payLoads.UserDto;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    // this is second entity of the blog project
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    // create user service
    @Override
    public UserDto createUser(UserDto userDto) {

        User user1=this.dtoToUser(userDto);
        User savedUser = this.userRepo.save(user1);
        return this.userToDto(savedUser);
    }

    // update user service
    @Override
    public UserDto updateUser(UserDto userDto, Integer userId) {

       User user= this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","Id",userId));

        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setAbout(userDto.getAbout());
        user.setPassword(userDto.getPassword());

        User updatedUser = this.userRepo.save(user);
        UserDto userDto1=this.userToDto(updatedUser);
        return userDto1;
    }

    // get single user service
    @Override
    public UserDto getUserById(Integer userId) {
        User user= this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","Id",userId));

        return this.userToDto(user);
    }

    // get all user service
    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = this.userRepo.findAll();
        List<UserDto> userDtos = users.stream().map(user -> this.userToDto(user)).collect(Collectors.toList());

        return userDtos;
    }

    // delete user service
    @Override
    public void deleteUser(Integer userId) {

        User user= this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","Id",userId));
        this.userRepo.delete(user);
    }

    public User dtoToUser(UserDto userDto){

        User user=this.modelMapper.map(userDto,User.class);
        return user;
    }

    public UserDto userToDto(User user){
        UserDto userDto=this.modelMapper.map(user,UserDto.class);
        return userDto;
    }
}
