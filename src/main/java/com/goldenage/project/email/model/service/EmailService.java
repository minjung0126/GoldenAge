package com.goldenage.project.email.model.service;

import com.goldenage.project.login.model.dto.AdminDTO;

import java.util.HashMap;

public interface EmailService {
    AdminDTO selectEmail(String id);

    int updateAuthNum(String id, String dbEmail, String authNum);

    AdminDTO matchAuthNum(String id, String email);

    int updatePassword(String id, String pw);
}
