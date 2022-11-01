package com.goldenage.project.product.model.dao;

import com.goldenage.project.product.model.dto.ProductDTO;
import com.goldenage.project.product.model.dto.ProductFileDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductMapper {

    int productRegist(ProductDTO productDTO);

    int productFileRegist(ProductFileDTO productFileDTO);
}
