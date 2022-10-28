package com.goldenage.project.product.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * product 페이지의 기능 구현을 위한 클래스
 * @author HeeChang
 * */
@Controller
@RequestMapping("/product")
public class ProductController {

    /**
    * <pre>
     *     product 페이지 조회 메소드
    * </pre>
    */
    @GetMapping("/productPage")
    public String productPage(){

        return "/product/productPage";
    }

    /**
     * <pre>
     *     detailPage 조회 메소드
     * </pre>
     */
    @GetMapping("/detailPage")
    public String detailPage(){

        return "/product/detailPage";
    }

    @GetMapping("/adminDetailPage")
    public String adminDetailPage(){

        return "/product/adminDetailPage";
    }
    /**
     * <pre>
     *     싱글 파일 업로드를 위한 코드
     * </pre>
     * */
//    @PostMapping("/upload/pic")
//    public String singleFileUpload(@RequestParam String fileContent, @RequestParam MultipartFile singleFile, HttpServletRequest request){
//
//        // 전송받은 파일 및 파일 설명 값 가져오기
//        System.out.println("singleFile : " + singleFile);
//        System.out.println("fileContent : " + fileContent);
//
//    }

}
