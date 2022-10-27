package com.goldenage.project.email.model.dao;

import com.goldenage.project.login.model.dto.AdminDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmailMapper {
    AdminDTO selectEmail(String id);

    int updateAuthNum(String id, String dbEmail, String authNum);
}
