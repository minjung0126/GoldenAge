package com.goldenage.project.space.controller;

import com.goldenage.project.space.model.service.SpaceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/space/*")
public class SpaceController {

    private final SpaceServiceImpl spaceService;

    @Autowired
    public SpaceController(SpaceServiceImpl spaceService) {
        this.spaceService = spaceService;
    }

    @GetMapping("/theater")
    public String theaher(){

        return "space/theater";
    }
}
