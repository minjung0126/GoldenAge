package com.goldenage.project.product.model.dao;

import com.goldenage.project.product.model.dto.ProductDTO;
import com.goldenage.project.product.model.dto.ProductFileDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {
    
    List<ProductDTO> selectAllProduct();

    ProductDTO selectOneProduct(String pd_num);

    List<ProductFileDTO> selectAllProductDetail(String pd_num);

    int insertPdInfo(ProductDTO productDTO);
}
