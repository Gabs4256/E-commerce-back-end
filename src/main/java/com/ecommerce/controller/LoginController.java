package com.ecommerce.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/signin")
    public String signIn() {
        return "signin";
    }

    @GetMapping("/signup")
    public String signUp() {
        return "signup";
    }

    @GetMapping("logout")
    public String logout() {
        return "redirect:/";
    }
}
