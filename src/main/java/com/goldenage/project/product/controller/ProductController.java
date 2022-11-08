package com.goldenage.project.product.controller;

import com.goldenage.project.product.model.dto.ProductDTO;

import com.goldenage.project.product.model.dto.ProductDetailDTO;
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
    public ModelAndView productDetail(ModelAndView mv, HttpServletRequest request
            , @RequestParam(value = "pd_num", required = false) String pd_num) {

        log.info("pd_num : " + pd_num);

        ProductDTO productDetail = productService.selectOneProduct(pd_num);
        List<ProductDetailDTO> productDetailDTOList = productService.selectAllProductDetail(pd_num);

        for(ProductDetailDTO pd : productDetailDTOList){
            System.out.println(pd);
        }

        mv.addObject("productDetail", productDetail);
        mv.addObject("productDetailDTOList", productDetailDTOList);

        mv.setViewName("/product/detailPage");

        return mv;
    }

    // 게시물 등록 get
    @GetMapping("/product_detail/regist")
    public ModelAndView productDetailInsert(ModelAndView mv, HttpServletRequest request) {

        mv.setViewName("/product/product_detail_new");
        return mv;
    }

    // 게시물 등록 post
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

    // 상세페이지 수정 get
    @GetMapping("/detailPage/update")
    public ModelAndView productDetailPageUpdate(ModelAndView mv, HttpServletRequest request, @RequestParam(value = "pd_num", required = false) String pd_num) {

        ProductDTO productDetail = productService.selectOneProduct(pd_num);
        List<ProductDetailDTO> productDetailDTOList = productService.selectAllProductDetail(pd_num);

        mv.addObject("productDetail", productDetail);
        mv.addObject("productDetailDTOList", productDetailDTOList);

        mv.setViewName("/product/detailPage_update");

        return mv;

    }

    // 상세페이지 수정 post
    @PostMapping("/detailPage/update")
    public String productDetailPageUpdate(@ModelAttribute ProductDTO productDTO, @RequestParam(value = "pd_num", required = false) String pd_num, @RequestParam(value = "file", required = false) MultipartFile file, RedirectAttributes rttr) throws Exception {

        log.info("ProductDTO : " + productDTO);
        log.info("파일 번호 : " + pd_num);
        log.info("ProductDetailDTO : " + file);

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

        productDTO.setPd_num(Integer.parseInt(pd_num));
        productService.updateProductInfoNoFile(productDTO);

        if (file.getSize() > 0) {
            originFileName = file.getOriginalFilename();
            ext = originFileName.substring(originFileName.lastIndexOf("."));
            changeName = UUID.randomUUID().toString().replace("-", "");

            productDTO.setPd_Ori_Main(originFileName);
            productDTO.setPd_File_Main(changeName + ext);

            log.info("다시 출력 : " + productDTO);

            productService.updateProductInfo(productDTO);

            try {
                file.transferTo(new File(filePath + "\\" + changeName + ext));
            } catch (IOException e) {
                e.printStackTrace();
                new File(filePath + "\\" + changeName + ext).delete();
            }

        }
            rttr.addFlashAttribute("message", "수정 성공!");
            rttr.addFlashAttribute("check", "success");

            return "redirect:/product/productPage";

    }

    @GetMapping("/detailPage/new/productPoster")
    public ModelAndView productDetailNewPoster(@ModelAttribute ProductDetailDTO productDetailDTO, ModelAndView mv, HttpServletRequest request){

        mv.setViewName("/product/product_new_poster");
        return mv;
    }

    @PostMapping("/detailPage/new/productPoster")
    public String productDetailNewPoster(@RequestParam(value="num", required = false) String pd_num, @ModelAttribute ProductDetailDTO productDetailDTO, @RequestParam(value = "file", required = false) MultipartFile file, RedirectAttributes rttr) throws Exception{

        log.info(pd_num);
        productDetailDTO.setPd_num(Integer.parseInt(pd_num));

        log.info("여기까진 왔냐?");

        log.info("테스트용 : " + productDetailDTO);
        log.info("사진 테스트 : " + file);

        String root = ResourceUtils.getURL("src/main/resources").getPath();

        String filePath = root + "static/images/product/poster";

        log.info("root --------------- " + filePath);

        File mkdir = new File(filePath);
        if(!mkdir.exists()){
            mkdir.mkdir();
        }

        String originFileName = "";
        String ext = "";
        String changeName = "";

        if(file.getSize() > 0) {
            originFileName = file.getOriginalFilename();
            ext = originFileName.substring(originFileName.lastIndexOf("."));
            changeName = UUID.randomUUID().toString().replace("-",  "");

            productDetailDTO.setDetail_ori_name(originFileName);
            productDetailDTO.setDetail_file_name(changeName + ext);

            log.info("다시 출력 : " + productDetailDTO);

            productService.insertPdPoster(productDetailDTO);

            try {
                file.transferTo(new File(filePath + "\\" + changeName + ext));
            } catch (IOException e){
                e.printStackTrace();
                new File(filePath + "\\" + changeName + ext).delete();
            }
            } else {
            productService.insertPdPoster(productDetailDTO);
        }

        rttr.addFlashAttribute("message", "등록 성공");
        rttr.addFlashAttribute("check", "success");

        return "redirect:/product/detailPage/update?pd_num=" + pd_num;

    }

    @GetMapping("/detailPage/update/poster")
    public ModelAndView productDetailUpdatePoster(ModelAndView mv, @RequestParam(value = "detail_file_num", required = false) String detail_file_num, RedirectAttributes rttr){

        ProductDetailDTO productDetailDTO = productService.selectProductPoster(detail_file_num);
        log.info("detail_file_num : " + detail_file_num);
        mv.addObject("productDetailDTO", productDetailDTO);
        mv.setViewName("/product/product_update_poster");
        
        log.info("여기까지 왔니");
        return mv;
    }

    @PostMapping("/detailPage/update/poster")
    public String productDetailUpdatePoster(@ModelAttribute ProductDetailDTO productDetailDTO, @RequestParam(value = "detail_file_num", required = false) String detail_file_num, @RequestParam(value = "file", required = false) MultipartFile file, RedirectAttributes rttr) throws Exception{
        log.info("pd_num : " + productDetailDTO.getPd_num());

        int pd_num = productDetailDTO.getPd_num();

        log.info("productDetailDTO " + productDetailDTO);
        log.info("아이템 넘버 : " + detail_file_num);
        log.info("productDetailDTO file : " + file);

        String root = ResourceUtils.getURL("src/main/resources").getPath();

        String filePath = root + "static/images/product/poster";

        log.info("루트 ------------- " + filePath);

        File mkdir = new File(filePath);
        if(!mkdir.exists()) {
            mkdir.mkdirs();
        }
        log.info("여기까지 왔니0");

        String originFileName = "";
        String ext = "";
        String changeName = "";

        log.info("여기까지 왔니1");
        productDetailDTO.setDetail_file_num(Integer.parseInt(detail_file_num));
        productService.updateProductPosterNoFile(productDetailDTO);

        if(file.getSize() > 0) {
            originFileName = file.getOriginalFilename();
            ext = originFileName.substring(originFileName.lastIndexOf("."));
            changeName = UUID.randomUUID().toString().replace("-", "");

            productDetailDTO.setDetail_ori_name(originFileName);
            productDetailDTO.setDetail_file_name(changeName + ext);

            productService.updateProductPoster(productDetailDTO);

            log.info("여기까지 왔니2");
            try {
                file.transferTo(new File(filePath + "\\" + changeName + ext));
            } catch (IOException e) {

                e.printStackTrace();
                new File(filePath + "\\" + changeName + ext).delete();
            }
        }
        log.info("여기까지 왔니3");

        rttr.addFlashAttribute("message", "수정 성공!");
        rttr.addFlashAttribute("check", "success");

        return "redirect:/product/detailPage/update?pd_num=" + pd_num;

    }


    // product 페이지 삭제
    @GetMapping("/detailPage/delete")
    public String productDetailDelete(@RequestParam(value="pd_num", required = false) String pd_num, RedirectAttributes rttr) throws Exception{

        productService.deleteProductInfo(pd_num);

        rttr.addFlashAttribute("message", "삭제 성공");

        return "redirect:/product/productPage";
    }

    // detailPage_update 에서 상세페이지 삭제
    @GetMapping("/detailPage/delete/poster")
    public String productDeletePoster(@ModelAttribute ProductDetailDTO productDetailDTO, RedirectAttributes rttr) throws Exception{

        int pd_num = productDetailDTO.getPd_num();
        int detail_file_num = productDetailDTO.getDetail_file_num();

        productService.deleteProductPoster(detail_file_num);

        rttr.addFlashAttribute("message", "삭제 성공");
        rttr.addFlashAttribute("check", "success");

        return "redirect:/product/detailPage/update?pd_num=" + pd_num;

    }

}

