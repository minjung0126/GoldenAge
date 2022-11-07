package com.goldenage.project.main.controller;

import com.goldenage.project.product.model.dto.ProductDTO;
import com.goldenage.project.product.service.ProductServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/")
public class Main {

    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private final ProductServiceImpl productService;

    @Autowired
    public Main(ProductServiceImpl productService) {
        this.productService = productService;
    }


    @GetMapping("/")
    public String moveMain(){

        return "/index";
    }

    @GetMapping("/mainPage")
    public ModelAndView mainProductPageList(HttpServletRequest request, ModelAndView mv){

        List<ProductDTO> productDTOList = productService.selectAllProduct();

        for (ProductDTO pro : productDTOList){
            System.out.println("pro: " + pro);
        }
        mv.addObject("productDTOList", productDTOList);
        mv.setViewName("/mainPage");

        return mv;

    }
}
