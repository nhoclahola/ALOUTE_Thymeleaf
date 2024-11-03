package com.nhoclahola.aloute_thymeleaf.controllers.api;

import com.nhoclahola.aloute_thymeleaf.entities.User;
import com.nhoclahola.aloute_thymeleaf.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController
{
    private final UserService userService;

    @GetMapping("")
    public ResponseEntity<List<User>> getAllUser()
    {
        return ResponseEntity.ok(userService.findAll());
    }
}
