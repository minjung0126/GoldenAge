package com.goldenage.project.company.model.dto;

public class CompanyDTO {

    private String companyName;
    private int comRepNum;
    private int phone;
    private String address;
    private String email;
    private String comRepName;

    public CompanyDTO() {
    }

    public CompanyDTO(String companyName, int comRepNum, int phone, String address, String email, String comRepName) {
        this.companyName = companyName;
        this.comRepNum = comRepNum;
        this.phone = phone;
        this.address = address;
        this.email = email;
        this.comRepName = comRepName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getComRepNum() {
        return comRepNum;
    }

    public void setComRepNum(int comRepNum) {
        this.comRepNum = comRepNum;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getComRepName() {
        return comRepName;
    }

    public void setComRepName(String comRepName) {
        this.comRepName = comRepName;
    }

    @Override
    public String toString() {
        return "CompanyDTO{" +
                "companyName='" + companyName + '\'' +
                ", comRepNum=" + comRepNum +
                ", phone=" + phone +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", comRepName='" + comRepName + '\'' +
                '}';
    }
}
