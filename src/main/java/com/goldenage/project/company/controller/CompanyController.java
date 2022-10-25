package com.goldenage.project.company.controller;

import com.goldenage.project.company.model.dto.CompanyDTO;
import com.goldenage.project.company.model.service.CompanyService;
import com.goldenage.project.company.model.service.CompanyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/company")
public class CompanyController {

    private final CompanyServiceImpl companyService;

    @Autowired
    public CompanyController(CompanyServiceImpl companyService){

        this.companyService = companyService;
    }

    // 방문자 회사 뷰 화면
    @GetMapping("/company")
    public ModelAndView company(ModelAndView mv){

        CompanyDTO comInfo = companyService.selectComInfo();

        mv.addObject("comInfo",comInfo);

        return mv;
    }

    @GetMapping("/company_update")
    public ModelAndView companyUpdate(ModelAndView mv){

        CompanyDTO comInfo = companyService.selectComInfos();

        mv.addObject("comInfo",comInfo);

        return mv;
    }
}
