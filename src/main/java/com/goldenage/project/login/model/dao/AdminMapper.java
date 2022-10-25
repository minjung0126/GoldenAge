package com.goldenage.project.login.model.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.security.core.userdetails.UserDetails;

@Mapper
public interface AdminMapper {
    UserDetails getUsername(String username);
}
