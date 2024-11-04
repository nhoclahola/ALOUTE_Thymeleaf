package com.nhoclahola.aloute_thymeleaf.mapper;

import com.nhoclahola.aloute_thymeleaf.dto.auth.request.UserCreateRequest;
import com.nhoclahola.aloute_thymeleaf.entities.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper
{
    User userLoginRequestToUser(UserCreateRequest request);
}
