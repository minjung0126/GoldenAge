package com.goldenage.project.product.service;

import com.goldenage.project.product.model.dto.ProductDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.File;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());


    public void productRegist(ProductDTO productDTO){

    }

    public void productDelete(ProductDTO productDTO){

    }
}
