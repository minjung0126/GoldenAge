package com.goldenage.project.email.controller;

import com.goldenage.project.email.model.service.EmailService;
import com.goldenage.project.login.model.dto.AdminDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Controller
@RequestMapping("/email/*")
public class EmailController {

    private final EmailService emailService;
    private JavaMailSender mailSender;

    @Autowired
    public EmailController(EmailService emailService, JavaMailSender mailSender){
        
        this.emailService = emailService;
    }

    @PostMapping("/submit")
    @ResponseBody
    public Object matchIdEmail(@RequestBody HashMap<String, String> adminMap) throws MessagingException, UnsupportedEncodingException {

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
                System.out.println("authNum : " + authNum);
                //인증번호 업데이트(id, email 기준)
                result = emailService.updateAuthNum(id, dbEmail, authNum);
                System.out.println("result udateAuthNum : " + result);

                if(result > 0) {

                    MailHandler mailHandler = new MailHandler(mailSender);
                    mailHandler.setSubject("골든에이지 인증코드 발송 이메일입니다.");
                    mailHandler.setText(
                            "<h1>골든에이지 이메일 인증</h1>" +
                                    "<br>골든에이지 비밀번호를 재설정하기 위한 인증 이메일입니다." +
                                    "<br>아래 인증번호를 입력해주세요." +
                                    "<br>[" + authKey + "]"
                    );
                    mailHandler.setFrom("intectme@naver.com", "GOLDENAGE");
                    mailHandler.setTo(dbEmail);
                    mailHandler.send();
                }

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
