package com.goldenage.project.product.service;

import com.goldenage.project.product.model.dao.ProductMapper;
import com.goldenage.project.product.model.dto.ProductDTO;
import com.goldenage.project.product.model.dto.ProductFileDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    private final ProductMapper productMapper;

    @Autowired
    public ProductServiceImpl(ProductMapper productMapper){

        this.productMapper = productMapper;
    }


    /**
     * <pre>
     *     productPage 갤러리형 리스트 조회
     * </pre>
     * */
    public List<ProductDTO> selectAllProduct() {

        List<ProductDTO> productDTOList = productMapper.selectAllProduct();
        return productDTOList;
    }

    /**
     * <pre>
     *     productDetail 페이지 조회
     * </pre>
     * */
    public ProductDTO selectOneProduct(String pd_num) {

        ProductDTO productDTO = productMapper.selectOneProduct(pd_num);
        return productDTO;
    }

    /**
     * <pre>
     *     productDetail 페이지 생성
     * </pre>
     * */
    public List<ProductFileDTO> selectAllProductDetail(String pd_num) {

        List<ProductFileDTO> productFileDTOList = productMapper.selectAllProductDetail(pd_num);
        return productFileDTOList;
    }

    /**
     * <pre>
     *     productDetail 페이지 생성
     * </pre>
     * */
    public void insertPdInfo(ProductDTO productDTO) {
    }

    public void productDelete(ProductDTO productDTO){

    }
}
