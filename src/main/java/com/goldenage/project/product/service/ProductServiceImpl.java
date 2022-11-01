package com.goldenage.project.product.service;

import com.goldenage.project.product.model.dao.ProductMapper;
import com.goldenage.project.product.model.dto.ProductDTO;
import com.goldenage.project.product.model.dto.ProductFileDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.File;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private ProductMapper productMapper;


    public void productRegist(ProductDTO productDTO){

        int result = 0;
        // product 테이블 insert
        int productResult = productMapper.productRegist(productDTO);

        List<ProductFileDTO> productFile = productDTO.getProductFileDTO();

        // 파일에 productNo 넣기
        for(int i = 0; i < productFile.size(); i++){
            productFile.get(i).setGalNo(productDTO.getPd_num());
            log.info("pd_num 값 가져오는지 확인 : " + productFile.get(i));
        }

        // productFile Insert
        int productFileResult = 0;
        for(int i = 0; i < productFile.size(); i++){
            productResult += productMapper.productFileRegist(productFile.get(i));
            log.info("확인합니다");
        }


    }
}
