package com.goldenage.project.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/*")
public class Login {

    @GetMapping("/login")
    public String adminLogin(){

        return "/admin/login";
    }

    @GetMapping("/password")
    public String findPassword(){

        return "/admin/password";
    }

    @GetMapping("/main")
    public String moveMain(){

        return "/index";
    }
}
