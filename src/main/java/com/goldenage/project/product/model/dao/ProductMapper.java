package com.goldenage.project.product.model.dao;

import com.goldenage.project.product.exception.PdException;
import com.goldenage.project.product.model.dto.ProductDTO;
import com.goldenage.project.product.model.dto.ProductDetailDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {
    
    List<ProductDTO> selectAllProduct();

    ProductDTO selectOneProduct(String pd_num);

    List<ProductDetailDTO> selectAllProductDetail(String pd_num);

    int insertPdInfo(ProductDTO productDTO);

    int updateProductInfoNoFile(ProductDTO productDTO);

    int updateProductInfo(ProductDTO productDTO);

    int deleteProductInfo(String pd_num);
}
