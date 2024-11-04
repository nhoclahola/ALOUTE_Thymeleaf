package com.nhoclahola.aloute_thymeleaf.services.implementations;

import com.nhoclahola.aloute_thymeleaf.dto.auth.request.UserCreateRequest;
import com.nhoclahola.aloute_thymeleaf.dto.auth.request.UserLoginRequest;
import com.nhoclahola.aloute_thymeleaf.entities.User;
import com.nhoclahola.aloute_thymeleaf.securities.JwtProvider;
import com.nhoclahola.aloute_thymeleaf.services.AuthService;
import com.nhoclahola.aloute_thymeleaf.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService
{
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public String authenticate(UserLoginRequest request)
    {
        User user = userService.findUserByEmail(request.getEmail());
        boolean authenticated = passwordEncoder.matches(request.getPassword(), user.getPassword());
        if (!authenticated)
            throw new RuntimeException("Unauthenticated");
        String jwtToken = JwtProvider.generateJwtToken(user);
        return jwtToken;
    }

    @Override
    public String register(UserCreateRequest request)
    {
        User user = userService.createUser(request);
        String jwtToken = JwtProvider.generateJwtToken(user);
        return jwtToken;
    }
}
