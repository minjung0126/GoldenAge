package com.example.goldenage.config;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * Mapper 사용을 위한 설정
 * @author Heechang
 *
 * */
@Configuration
@MapperScan(basePackages = "com.example.goldenage", annotationClass = Mapper.class)
public class MybatisConfig {
}
