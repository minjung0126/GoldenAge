package com.goldenage.project.company.model.dto;

public class CompanyDTO {

    private String companyName;
    private int comRepNum;
    private String phone;
    private String address;
    private String email;
    private String comRepName;
    private String instagram;
    private String twitter;

    public CompanyDTO() {
    }

    public CompanyDTO(String companyName, int comRepNum, String phone, String address, String email, String comRepName, String instagram, String twitter) {
        this.companyName = companyName;
        this.comRepNum = comRepNum;
        this.phone = phone;
        this.address = address;
        this.email = email;
        this.comRepName = comRepName;
        this.instagram = instagram;
        this.twitter = twitter;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
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

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    @Override
    public String toString() {
        return "CompanyDTO{" +
                "companyName='" + companyName + '\'' +
                ", comRepNum=" + comRepNum +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", comRepName='" + comRepName + '\'' +
                ", instagram='" + instagram + '\'' +
                ", twitter='" + twitter + '\'' +
                '}';
    }
}
