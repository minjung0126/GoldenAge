package com.goldenage.project.company.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/company/*")
public class CompanyController {

    @GetMapping("/user/view")
    public String company(){

        return "/company";
    }
}
