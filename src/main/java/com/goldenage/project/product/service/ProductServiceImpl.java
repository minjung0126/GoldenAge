package com.goldenage.project.product.service;

import com.goldenage.project.product.exception.PdException;
import com.goldenage.project.product.model.dao.ProductMapper;
import com.goldenage.project.product.model.dto.ProductDTO;
import com.goldenage.project.product.model.dto.ProductDetailDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    @Override
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
     *     productDetail 페이지 상세 이미지조회
     * </pre>
     * */
    public List<ProductDetailDTO> selectAllProductDetail(String pd_num) {

        List<ProductDetailDTO> productDetailDTOList = productMapper.selectAllProductDetail(pd_num);
        return productDetailDTOList;
    }

    /**
     * <pre>
     *     productDetail 페이지 생성
     * </pre>
     * */
    @Override
    @Transactional
    public int insertPdInfo(ProductDTO productDTO) throws PdException {

        int result = productMapper.insertPdInfo(productDTO);

        if(!(result > 0)){
            throw new PdException("등록 실패");
        }

        return result;
    }


    @Override
    @Transactional
    public int updateProductInfoNoFile(ProductDTO productDTO) throws PdException{

        int result = productMapper.updateProductInfoNoFile(productDTO);

        if(!(result > 0)){
            throw new PdException("수정 실패");
        }

        return result;
    }

    @Override
    @Transactional
    public int updateProductInfo(ProductDTO productDTO) throws PdException {

        int result = productMapper.updateProductInfo(productDTO);

        if(!(result > 0)){
            throw new PdException("수정 실패");
        }

        return result;

    }

    @Override
    @Transactional
    public int deleteProductInfo(String pd_num) throws PdException{
        int result = productMapper.deleteProductInfo(pd_num);

        if(!(result > 0)){
            throw new PdException("삭제 실패");
        }

        return result;
    }
}
