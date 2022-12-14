package com.goldenage.project.email.model.service;

import com.goldenage.project.email.model.dao.EmailMapper;
import com.goldenage.project.login.model.dao.AdminMapper;
import com.goldenage.project.login.model.dto.AdminDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;

@Service
public class EmailServiceImpl implements EmailService{

    private EmailMapper emailMapper;

    @Autowired
    public EmailServiceImpl(EmailMapper emailMapper){

        this.emailMapper = emailMapper;
    }
    @Override
    public AdminDTO selectEmail(String id) {

        AdminDTO ckEmail = emailMapper.selectEmail(id);

        return ckEmail;
    }

    @Override
    @Transactional
    public int updateAuthNum(String id, String dbEmail, String authNum) {

        int result = emailMapper.updateAuthNum(id, dbEmail, authNum);

        return result;
    }

    @Override
    public AdminDTO matchAuthNum(String id, String email) {

        AdminDTO adminDTO = emailMapper.matchAuthNum(id, email);

        return adminDTO;
    }

    @Override
    @Transactional
    public int updatePassword(String id, String pw) {

        int result = emailMapper.updatePassword(id, pw);

        return result;
    }
}
