package com.goldenage.project.email.controller;

import java.util.Random;

public class AuthKey {

    //인증번호 랜덤 생성
    public String makeAuthKey(){

        Random ran = new Random();
        StringBuffer sb = new StringBuffer();

        do {

            int num = ran.nextInt(10);

            sb.append(num);

        } while(sb.length() < 8);

        return sb.toString();
    }
}
