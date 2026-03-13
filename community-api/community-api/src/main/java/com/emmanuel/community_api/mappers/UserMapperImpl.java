package com.emmanuel.community_api.mappers;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.emmanuel.community_api.dtos.UserDto;
import com.emmanuel.community_api.entities.User;

@Service
public class UserMapperImpl {
    public UserDto fromUser(User user){
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(user, userDto);
        return userDto;
    }

    public User fromUserDto(UserDto userDto){
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        return user;
    }
}
