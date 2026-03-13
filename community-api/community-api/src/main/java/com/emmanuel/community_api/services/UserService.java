package com.emmanuel.community_api.services;

import java.util.List;

import com.emmanuel.community_api.dtos.UserDto;

public interface UserService {
    UserDto createUser(UserDto userDto);
    UserDto getUserById(String id);
    List<UserDto> getAllUser();
    UserDto updateUser(String id, UserDto userDto);
    void deleteUser(String id);

}
