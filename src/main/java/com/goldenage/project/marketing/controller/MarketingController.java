package com.goldenage.project.marketing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/marketing")
public class MarketingController {

    @GetMapping("/list")
    public String marketingList(){

        return "/marketing/marketing";
    }

    @GetMapping("/detail")
    public String marketingDetail(){

        return "/marketing/marketing_detail";
    }
}
