package com.emmanuel.community_api.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.emmanuel.community_api.repositories.UserRepository;
import com.emmanuel.community_api.dtos.UserDto;
import com.emmanuel.community_api.entities.User;
import com.emmanuel.community_api.mappers.UserMapperImpl;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private UserMapperImpl userMapper;
    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, UserMapperImpl userMapper, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }

    public UserDto createUser(UserDto userDto) {
        User user = userMapper.fromUserDto(userDto);
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        User savedUser = userRepository.save(user);
        return userMapper.fromUser(savedUser);
    }

    public UserDto getUserById(String id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        return userMapper.fromUser(user);
    }

    public List<UserDto> getAllUser() {
        List<User> users =  userRepository.findAll();
        List<UserDto> userDtos =users.stream().map(user->userMapper.fromUser(user)).collect(Collectors.toList());
        return userDtos;
    }

    public UserDto updateUser(String id, UserDto user) {
        User existingUser = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        existingUser.setPseudo(user.getPseudo());
        existingUser.setEmail(user.getEmail());
        if (user.getPassword() != null) {
            existingUser.setPassword(passwordEncoder.encode(user.getPassword()));
        }
        
        User updatedUser = userRepository.save(existingUser);
        return userMapper.fromUser(updatedUser);
    }

    public void deleteUser(String id) {
        User User = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        userRepository.delete(User);
    }

}
