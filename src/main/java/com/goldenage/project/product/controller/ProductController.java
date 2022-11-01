package com.goldenage.project.product.controller;

import com.goldenage.project.product.model.dto.ProductDTO;

import com.goldenage.project.product.model.dto.ProductFileDTO;
import com.goldenage.project.product.service.ProductServiceImpl;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.*;

import org.slf4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * product 페이지의 기능 구현을 위한 클래스
 * @author HeeChang
 * */
@Controller
@RequestMapping("/product")
public class ProductController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private final ProductServiceImpl productService;

    @Autowired
    public ProductController(ProductServiceImpl productService) {

        this.productService = productService;
    }


    /**
     * <pre>
     *     productPage 조회 메소드
     * </pre>
     */
    @GetMapping("/productPage")
    public ModelAndView productPageList(HttpServletRequest request, ModelAndView mv) {

        List<ProductDTO> productDTOList = productService.selectAllProduct();

        mv.addObject("productDTOList", productDTOList);
        mv.setViewName("/product/productPage");

        return mv;
    }

    /**
     * <pre>
     *     product/detailPage 조회 메소드
     * </pre>
     */
    @GetMapping("/detailPage")
    public ModelAndView productDetail(ModelAndView mv, HttpServletRequest request, @RequestParam(value = "pd_num", required = false) String pd_num) {

        String num = request.getParameter("pd_num");
        log.info("pd_num : " + pd_num);

        ProductDTO productDetail = productService.selectOneProduct(pd_num);
        List<ProductFileDTO> productFileDTOList = productService.selectAllProductDetail(pd_num);

        mv.addObject("productDetail", productDetail);
        mv.addObject("productFileList", productFileDTOList);

        mv.setViewName("/product/detailPage");

        return mv;
    }

    @GetMapping("/product_detail/regist")
    public ModelAndView productDetailInsert(ModelAndView mv, HttpServletRequest request){

        mv.setViewName("/product/product_detail_new");
        return mv;
    }

    @PostMapping("/product_detail/regist")
    public String productDetailInsert(@ModelAttribute ProductDTO productDTO, @RequestParam(value = "file", required = false) MultipartFile file, RedirectAttributes rttr) throws Exception {

        log.info("테스트용 : " + productDTO);
        log.info("사진 테스트 : " + file);

        String root = ResourceUtils.getURL("src/main/resources").getPath();

        String filePath = root + "static/images/product";

        log.info("root ---------------- " + filePath);

        File mkdir = new File(filePath);
        if (!mkdir.exists()) {
            mkdir.mkdirs();
        }

        String originFileName = "";
        String ext = "";
        String changeName = "";

        if (file.getSize() > 0) {
            originFileName = file.getOriginalFilename();
            ext = originFileName.substring(originFileName.lastIndexOf("."));
            changeName = UUID.randomUUID().toString().replace("-", "");

            productDTO.setPd_Ori_Main(originFileName);
            productDTO.setPd_File_Main(changeName + ext);

            log.info("다시 출력 : " + productDTO);

            // 공연 등록
            productService.insertPdInfo(productDTO);

            try {
                file.transferTo(new File(filePath + "\\" + changeName + ext));
            } catch (IOException e) {
                e.printStackTrace();
                new File(filePath + "\\" + changeName + ext).delete();
            }
        } else {
            productService.insertPdInfo(productDTO);
        }

        return "redirect:/product/productPage";

    }


}

