package com.nhoclahola.aloute_thymeleaf.services.implementations;

import com.nhoclahola.aloute_thymeleaf.dto.auth.request.UserCreateRequest;
import com.nhoclahola.aloute_thymeleaf.entities.Role;
import com.nhoclahola.aloute_thymeleaf.entities.User;
import com.nhoclahola.aloute_thymeleaf.mapper.UserMapper;
import com.nhoclahola.aloute_thymeleaf.repositories.UserRepository;
import com.nhoclahola.aloute_thymeleaf.services.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService
{
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public List<User> findAll()
    {
        return userRepository.findAll();
    }

    @Override
    @Transactional
    public User createUser(UserCreateRequest request)
    {
        if (userRepository.existsByEmail(request.getEmail()))
            throw new RuntimeException("Email already exists");
        if (userRepository.existsByUsername(request.getUsername()))
            throw new RuntimeException("Username already exists");
        User user = userMapper.userLoginRequestToUser(request);
        // userId is already null after mapping,
        // Just don't set it, Hibernate won't check it is exist or not again
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Role.USER);
        return userRepository.save(user);
    }

    @Override
    public User findUserById(String userId)
    {
        return userRepository.findById(userId).orElseThrow(() ->
                new RuntimeException("User does not exist"));
    }

    @Override
    public User findUserByEmail(String email)
    {
        return userRepository.findByEmail(email).orElseThrow(() ->
                new RuntimeException("User does not exist"));
    }
}
