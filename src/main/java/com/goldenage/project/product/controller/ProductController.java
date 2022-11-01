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
import net.coobird.thumbnailator.Thumbnails;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

import org.slf4j.Logger;
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

    private String IMAGE_DIR;

    @Autowired
    public ProductController(ProductServiceImpl productService) {

        this.productService = productService;
    }


    /**
     * <pre>
     *     product 페이지 조회 메소드
     * </pre>
     */
    @GetMapping("/productPage")
    public String productPage() {

        return "/product/productPage";
    }

    /**
     * <pre>
     *     detailPage 조회 메소드
     * </pre>
     */
    @GetMapping("/detailPage")
    public String detailPage() {

        return "/product/detailPage";
    }

    @GetMapping("/adminDetailPage")
    public String adminDetailPage() {

        return "/product/adminDetailPage";
    }

    /**
     * <pre>
     *     파일 업로드를 위한 코드
     * </pre>
     */
    @PostMapping("/upload/pic")
    public String imageUpload(@ModelAttribute ProductDTO productDTO, HttpServletRequest request,
                              @RequestParam("thumnailImg1") MultipartFile thumbnailImg1,
                              @RequestParam("thumnailImg2") MultipartFile thumbnailImg2,
                              @RequestParam("thumnailImg3") MultipartFile thumbnailImg3,
                              @RequestParam("thumnailImg4") MultipartFile thumbnailImg4,
                              RedirectAttributes rttr) throws FileNotFoundException {

        String rootLocation = IMAGE_DIR;

        String filePath = ResourceUtils.getURL("src/main/resources").getPath() + "upload";
        String fileUploadDirectory = filePath + "/galleryFile";
        String thumbnailDirectory = filePath + "/thumbnailFile";

        File directory = new File(fileUploadDirectory);
        File directory2 = new File(thumbnailDirectory);

        // 파일 폴더 자동 생성
        if (!directory.exists() || !directory2.exists()) {

            directory.mkdirs();
            directory2.mkdirs();
        }

        List<Map<String, String>> fileList = new ArrayList<>();

        List<MultipartFile> paramFileList = new ArrayList<>();
        paramFileList.add(thumbnailImg1);
        paramFileList.add(thumbnailImg2);
        paramFileList.add(thumbnailImg3);
        paramFileList.add(thumbnailImg4);

        for (MultipartFile paramFile : paramFileList) {

            if (paramFile.getSize() > 0) {
                String originFileName = paramFile.getOriginalFilename();

                String ext = originFileName.substring(originFileName.lastIndexOf("."));
                if (ext != "jpg" || ext != "png" || ext != "gif" || ext != "jpeg") {
                }

                String savedFileName = UUID.randomUUID().toString() + ext;

                try {
                    paramFile.transferTo(new File(fileUploadDirectory + "/" + savedFileName));

                    Map<String, String> fileMap = new HashMap<>();
                    fileMap.put("originFileName", originFileName);
                    fileMap.put("savedFileName", savedFileName);
                    fileMap.put("savePath", fileUploadDirectory);

                    String filedName = paramFile.getName();

                    Thumbnails.of(fileUploadDirectory + "/" + savedFileName).toFile(thumbnailDirectory + "/thumb_" + savedFileName);

                    fileMap.put("thumnailPath", "/upload/thumnailFile/thumb_" + savedFileName);

                    fileList.add(fileMap);

                    productDTO.setProductFileDTO(new ArrayList<ProductFileDTO>());
                    List<ProductFileDTO> list = productDTO.getProductFileDTO();
                    for (int i = 0; i < fileList.size(); i++) {
                        Map<String, String> file = fileList.get(i);

                        ProductFileDTO tempFileInfo = new ProductFileDTO();
                        tempFileInfo.setOriginName(file.get("originFileName"));
                        tempFileInfo.setSaveName(file.get("savedFileName"));
                        tempFileInfo.setSavePath(file.get("savePath"));
                        tempFileInfo.setThumbnailPath(file.get("thumbnailPath"));
                        tempFileInfo.setFileType(file.get("fileType"));

                        list.add(tempFileInfo);
                    }

                } catch (IllegalStateException | IOException e) {
                    e.printStackTrace();
                    //Exception 발생 시 파일 삭제

                    int cnt = 0;
                    for (int i = 0; i < fileList.size(); i++) {
                        Map<String, String> file = fileList.get(i);

                        File deleteFile = new File(fileUploadDirectory + "/" + file.get("savedFileName"));
                        boolean isDeleted1 = deleteFile.delete();

                        File deleteThumnail = new File(thumbnailDirectory + "/thumb_" + file.get("savedFileName"));
                        boolean isDeleted2 = deleteThumnail.delete();

                        if (isDeleted1 && isDeleted2) {
                            cnt++;
                        }
                    }

                    if (cnt == fileList.size()) {
                        log.info("업로드 실패한 사진 삭제 완료");
                        e.printStackTrace();
                    } else {
                        e.printStackTrace();
                    }
                }
            }
        }

        productService.productRegist(productDTO); // product insert

        rttr.addFlashAttribute("message", "등록이 완료되었습니다.");
        return "redirect:/product/productPage";


    }

    /**
     * <pre>
     *     product 삭제 요청 메소드
     * </pre>
     * */
    @GetMapping("/product/delete")
    public String productDelete(@ModelAttribute ProductDTO productDTO, HttpServletRequest request){

        int no = Integer.parseInt(request.getParameter("no"));

        productService.productDelete(productDTO);

        return "redirect:/product/productPage";

    }

}

