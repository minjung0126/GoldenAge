package com.goldenage.project.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/admin/*")
public class LoginController {

    @GetMapping("/loginPage")
    public String adminLoginPage(){

        return "/admin/loginPage";
    }

    @GetMapping("/password")
    public String findPassword(){

        return "/admin/password";
    }

    @GetMapping("/failure")
    public String loginFailure(){

        return "/common/denied";
    }
}
