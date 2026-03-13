package com.emmanuel.community_api.web;

import org.springframework.web.bind.annotation.RestController;

import com.emmanuel.community_api.dtos.UserDto;
import com.emmanuel.community_api.services.UserService;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class UserRestController {

    private UserService userService;

    public UserRestController(UserService userService){
        this.userService = userService;
    }

    @GetMapping(path = "/api/v1/users")
    public List<UserDto> getAllUsers() {
        return userService.getAllUser();
    }

    @GetMapping(path = "/api/v1/users/{userId}")
    public UserDto getUserById(@PathVariable String userId) {
        return userService.getUserById(userId);
    }
    
    @PostMapping("/api/v1/users")
    public UserDto saveUser(@RequestBody UserDto userDto){
        return userService.createUser(userDto);
    }
    @PutMapping("/api/v1/users/{userId}")
    public UserDto updateUser(@PathVariable String userId, @RequestBody UserDto userDto){
        return userService.updateUser(userId, userDto);
    }
    @DeleteMapping("/api/v1/users/{userId}")
    public void deleteUser(@PathVariable String userId){
        userService.deleteUser(userId);
    }
      
}
