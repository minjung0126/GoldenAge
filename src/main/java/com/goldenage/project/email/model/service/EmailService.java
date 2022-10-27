package com.goldenage.project.email.model.service;

import com.goldenage.project.login.model.dto.AdminDTO;

public interface EmailService {
    AdminDTO selectEmail(String id);
    int updateAuthNum(String id, String dbEmail, String authNum);

}
