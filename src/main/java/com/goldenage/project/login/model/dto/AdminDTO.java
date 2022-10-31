package com.goldenage.project.login.model.dto;

import java.util.List;

public class AdminDTO {

    private int adminNum;
    private String adminName;
    private String adminId;
    private String adminPwd;
    private String adminEmail;
    private int authCode;
    private String authNum;
    public AdminDTO(){}

    public AdminDTO(int adminNum, String adminName, String adminId, String adminPwd, String adminEmail, int authCode, String authNum) {
        this.adminNum = adminNum;
        this.adminName = adminName;
        this.adminId = adminId;
        this.adminPwd = adminPwd;
        this.adminEmail = adminEmail;
        this.authCode = authCode;
        this.authNum = authNum;
    }

    public int getAdminNum() {
        return adminNum;
    }

    public void setAdminNum(int adminNum) {
        this.adminNum = adminNum;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getAdminPwd() {
        return adminPwd;
    }

    public void setAdminPwd(String adminPwd) {
        this.adminPwd = adminPwd;
    }

    public String getAdminEmail() {
        return adminEmail;
    }

    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }

    public int getAuthCode() {
        return authCode;
    }

    public void setAuthCode(int authCode) {
        this.authCode = authCode;
    }

    public String getAuthNum() {
        return authNum;
    }

    public void setAuthNum(String authNum) {
        this.authNum = authNum;
    }

    @Override
    public String toString() {
        return "AdminDTO{" +
                "adminNum=" + adminNum +
                ", adminName='" + adminName + '\'' +
                ", adminId='" + adminId + '\'' +
                ", adminPwd='" + adminPwd + '\'' +
                ", adminEmail='" + adminEmail + '\'' +
                ", authCode=" + authCode +
                ", authNum='" + authNum + '\'' +
                '}';
    }
}
