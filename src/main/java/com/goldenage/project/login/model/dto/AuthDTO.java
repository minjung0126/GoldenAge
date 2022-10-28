package com.goldenage.project.login.model.dto;

public class AuthDTO {

    private int authCode;
    private String authName;

    public AuthDTO(){}

    public AuthDTO(int authCode, String authName) {
        this.authCode = authCode;
        this.authName = authName;
    }

    public int getAuthCode() {
        return authCode;
    }

    public void setAuthCode(int authCode) {
        this.authCode = authCode;
    }

    public String getAuthName() {
        return authName;
    }

    public void setAuthName(String authName) {
        this.authName = authName;
    }

    @Override
    public String toString() {
        return "AuthDTO{" +
                "authCode='" + authCode + '\'' +
                ", authName='" + authName + '\'' +
                '}';
    }
}
