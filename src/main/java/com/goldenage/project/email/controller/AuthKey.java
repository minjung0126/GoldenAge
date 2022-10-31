package com.goldenage.project.email.controller;

import java.util.Random;

public class AuthKey {

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
