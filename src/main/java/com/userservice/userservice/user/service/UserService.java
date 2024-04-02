package com.userservice.userservice.user.service;


import com.userservice.userservice.user.dto.UserDto;
import com.userservice.userservice.user.repository.UserEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    UserDto createUser(UserDto userDto);
    UserDto getUserByUserId(String userId);
    Iterable<UserEntity> getUserByAll();
/*
    UserDto getUserDetailsByEmail(String userName);*/
}
