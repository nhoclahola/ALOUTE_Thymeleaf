package com.nhoclahola.aloute_thymeleaf.controllers.web.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class HomeController
{
    @GetMapping("")
    public String getAll()
    {
        return "user/test";
    }
}
