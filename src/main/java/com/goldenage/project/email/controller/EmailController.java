package com.goldenage.project.email.controller;

import com.goldenage.project.email.model.service.EmailService;
import com.goldenage.project.login.model.dto.AdminDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Controller
@RequestMapping("/email/*")
public class EmailController {

    private final EmailService emailService;

    @Autowired
    public EmailController(EmailService emailService){

        this.emailService = emailService;
    }

    @PostMapping("/submit")
    @ResponseBody
    public Object matchIdEmail(@RequestBody HashMap<String, String> adminMap){

        System.out.println("adminMap : " + adminMap);

        String id = adminMap.get("id");
        String email = adminMap.get("email");

        AdminDTO ckEmail = emailService.selectEmail(id);
        System.out.println("ckEmail : " + ckEmail);

        int result = 0;

        if(ckEmail != null){

            String dbEmail = ckEmail.getAdminEmail();
            System.out.println("dbEmail : " + dbEmail);

            if(email.equals(dbEmail)) {

                //인증번호생성
                AuthKey authKey = new AuthKey();
                String authNum = authKey.makeAuthKey();

                //인증번호 업데이트(id, email 기준)
                result = emailService.updateAuthNum(id, dbEmail, authNum);



            } else if(!email.equals(dbEmail)){

                result = 0;
            }
            //인증번호 메일 전송

        } else {

            result = 0;
        }

        System.out.println("result : " + result);

        //인증번호 매치
        //비밀번호 업데이트

        Map<String, Object> resultAjax = new HashMap<>();
        resultAjax.put("result", result);

        return resultAjax;
    }
}
