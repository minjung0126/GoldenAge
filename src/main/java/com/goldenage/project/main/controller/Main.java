package com.goldenage.project.main.controller;

import com.goldenage.project.marketing.model.dto.MarketingDTO;
import com.goldenage.project.marketing.model.service.MarketingServiceImpl;
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
public class Main {

    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private final ProductServiceImpl productService;

    private final MarketingServiceImpl marketingService;

    @Autowired
    public Main(ProductServiceImpl productService, MarketingServiceImpl marketingService) {
        this.productService = productService;
        this.marketingService = marketingService;
    }

   // @GetMapping("/")
   // public String moveMain(){

   //     return "/index";
   // }

    @GetMapping("/")
    public ModelAndView mainProductPageList(HttpServletRequest request, ModelAndView mv){
        System.out.println("index : 인덱스왓니");
        log.info("index : 인덱스");
        List<ProductDTO> productDTOList = productService.selectAllProduct();
        List<MarketingDTO> marketingList = marketingService.selectAllMarketing();
        mv.addObject("productDTOList", productDTOList);
        mv.addObject("marketingList", marketingList);
        mv.setViewName("mainPage");

        return mv;

    }
}
