package com.second_service.user.repository;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository  extends CrudRepository<UserEntity,Long> {

    UserEntity findByUserId(String userId);
}
