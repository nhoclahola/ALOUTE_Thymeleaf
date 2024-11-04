package com.nhoclahola.aloute_thymeleaf.mapper;

import com.nhoclahola.aloute_thymeleaf.dto.auth.request.UserCreateRequest;
import com.nhoclahola.aloute_thymeleaf.dto.user.response.UserResponse;
import com.nhoclahola.aloute_thymeleaf.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper
{
    User userLoginRequestToUser(UserCreateRequest request);

    UserResponse toUserResponse(User user);
}
