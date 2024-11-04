package com.nhoclahola.aloute_thymeleaf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;

@SpringBootApplication(exclude = {UserDetailsServiceAutoConfiguration.class})
public class AlouteThymeleafApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(AlouteThymeleafApplication.class, args);
    }

}
