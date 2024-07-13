package com.Blog_Project.Controller;

import com.Blog_Project.Services.UserService;
import com.Blog_Project.payLoads.ApiResponse;
import com.Blog_Project.payLoads.UserDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Post - Create


    @PostMapping("/")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto){
        UserDto createUserDto = this.userService.createUser(userDto);
        return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);

    }

    // Put - Update user

    @PutMapping("/{userId}")  // userId is URI template path variable. esme jo id aaygi wo @pathvariable annotation se uID me bind ho jayga.
    public ResponseEntity<UserDto> updateUser( @Valid @RequestBody UserDto userDto , @PathVariable("userId") Integer uId){
        UserDto updatedUser = this.userService.updateUser(userDto, uId);
        return  ResponseEntity.ok(updatedUser);
    }


    // Delete user

    @DeleteMapping("/{userId}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable ("userId") Integer uId){

        this.userService.deleteUser(uId);
        return new ResponseEntity<ApiResponse> (new ApiResponse("User Deleted successfully", true),HttpStatus.OK);
    }

    // Get user

    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getUser(@PathVariable("userId") Integer userId){
        return ResponseEntity.ok(this.userService.getUserById(userId));
    }

    // Get all users

    @GetMapping("/")
    private ResponseEntity<List<UserDto>> getAllUser(){

        return ResponseEntity.ok(this.userService.getAllUsers());
    }
}