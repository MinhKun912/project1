package com.example.jobportal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    @GetMapping("/register")
    public String showRegisterForm() {
        return "register"; // trỏ tới register.html trong templates
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login"; // trỏ tới login.html
    }
}
