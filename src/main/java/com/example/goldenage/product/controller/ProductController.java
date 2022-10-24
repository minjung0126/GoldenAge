package com.example.goldenage.product.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * product 페이지의 기능 구현을 위한 클래스
 * @author HeeCHang
 * */
public class ProductController {

    /**
    * <pre>
     *     product 페이지 조회 메소드
    * </pre>
    */
    @GetMapping("/product")
    public String productPage(){

        return "product";
    }
}
