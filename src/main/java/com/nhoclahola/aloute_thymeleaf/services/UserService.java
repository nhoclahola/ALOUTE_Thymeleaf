package com.nhoclahola.aloute_thymeleaf.services;

import com.nhoclahola.aloute_thymeleaf.entities.User;

import java.util.List;

public interface UserService
{
    List<User> findAll();
}
