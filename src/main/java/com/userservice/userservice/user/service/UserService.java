package com.userservice.userservice.user.service;


import com.userservice.userservice.user.dto.UserDto;
import com.userservice.userservice.user.repository.UserEntity;

public interface UserService {
    UserDto createUser(UserDto userDto);
    UserDto getUserByUserId(String userId);
    Iterable<UserEntity> getUserByAll();
/*
    UserDto getUserDetailsByEmail(String userName);*/
}
