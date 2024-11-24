package com.nhoclahola.aloute_thymeleaf.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class IndexController
{
    @GetMapping("/")
    public String getAll(Authentication authentication, Model model)
    {
        model.addAttribute("authentication", authentication);
        return "index";
    }
}
