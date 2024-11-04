package com.nhoclahola.aloute_thymeleaf.services;

import com.nhoclahola.aloute_thymeleaf.dto.auth.request.UserCreateRequest;
import com.nhoclahola.aloute_thymeleaf.dto.auth.request.UserLoginRequest;

public interface AuthService
{
    String authenticate(UserLoginRequest request);

    String register(UserCreateRequest request);
}
