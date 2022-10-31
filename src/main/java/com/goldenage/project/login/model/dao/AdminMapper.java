package com.goldenage.project.login.model.dao;

import com.goldenage.project.login.model.dto.AdminDTO;
import com.goldenage.project.login.model.dto.AdminDTOImpl;
import com.goldenage.project.login.model.dto.AuthDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminMapper {
    AdminDTO selectAdminDTO(String username);

    List<AuthDTO> selectAuthDTO();
}
