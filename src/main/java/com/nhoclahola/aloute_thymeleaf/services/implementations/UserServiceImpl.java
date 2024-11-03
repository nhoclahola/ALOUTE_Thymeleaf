package com.nhoclahola.aloute_thymeleaf.services.implementations;

import com.nhoclahola.aloute_thymeleaf.entities.User;
import com.nhoclahola.aloute_thymeleaf.repositories.UserRepository;
import com.nhoclahola.aloute_thymeleaf.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService
{
    private final UserRepository userRepository;

    @Override
    public List<User> findAll()
    {
        return userRepository.findAll();
    }
}
