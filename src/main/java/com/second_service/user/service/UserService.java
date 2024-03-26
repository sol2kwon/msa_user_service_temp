package com.second_service.user.service;

import com.second_service.user.dto.UserDto;
import com.second_service.user.repository.UserEntity;

public interface UserService {
    UserDto createUser(UserDto userDto);
/*    UserDto getUserByUserId(String userId);
    Iterable<UserEntity> getUserByAll();

    UserDto getUserDetailsByEmail(String userName);*/
}
