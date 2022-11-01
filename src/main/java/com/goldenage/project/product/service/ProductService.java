package com.goldenage.project.product.service;

import com.goldenage.project.marketing.model.dto.MarketingDTO;
import com.goldenage.project.product.exception.PdException;
import com.goldenage.project.product.model.dto.ProductDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ProductService {

    List<ProductDTO> selectAllProduct();

    ProductDTO selectOneProduct(String pd_num);

    @Transactional
    int insertPdInfo(ProductDTO productDTO) throws PdException;
}
