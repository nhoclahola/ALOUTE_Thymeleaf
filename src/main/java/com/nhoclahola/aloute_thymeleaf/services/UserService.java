package com.nhoclahola.aloute_thymeleaf.services;

import com.nhoclahola.aloute_thymeleaf.dto.auth.request.UserCreateRequest;
import com.nhoclahola.aloute_thymeleaf.entities.User;
import jakarta.transaction.Transactional;

import java.util.List;

public interface UserService
{
    List<User> findAll();

    @Transactional
    User createUser(UserCreateRequest request);

    User findUserById(String userId);

    User findUserByEmail(String email);
}
