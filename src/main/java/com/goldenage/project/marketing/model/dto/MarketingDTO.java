package com.goldenage.project.marketing.model.dto;

import java.sql.Date;

public class MarketingDTO {

    private int mkNum;
    private String mkName;
    private java.sql.Date mkStartDate;
    private java.sql.Date mkEndDate;
    private String mkPlaceName;
    private String mkProduct;
    private String mkOriMain;
    private String mkFileMain;
    private String companyName;

    public MarketingDTO() {
    }

    public MarketingDTO(int mkNum, String mkName, Date mkStartDate, Date mkEndDate, String mkPlaceName, String mkProduct, String mkOriMain, String mkFileMain, String companyName) {
        this.mkNum = mkNum;
        this.mkName = mkName;
        this.mkStartDate = mkStartDate;
        this.mkEndDate = mkEndDate;
        this.mkPlaceName = mkPlaceName;
        this.mkProduct = mkProduct;
        this.mkOriMain = mkOriMain;
        this.mkFileMain = mkFileMain;
        this.companyName = companyName;
    }

    public int getMkNum() {
        return mkNum;
    }

    public void setMkNum(int mkNum) {
        this.mkNum = mkNum;
    }

    public String getMkName() {
        return mkName;
    }

    public void setMkName(String mkName) {
        this.mkName = mkName;
    }

    public Date getMkStartDate() {
        return mkStartDate;
    }

    public void setMkStartDate(Date mkStartDate) {
        this.mkStartDate = mkStartDate;
    }

    public Date getMkEndDate() {
        return mkEndDate;
    }

    public void setMkEndDate(Date mkEndDate) {
        this.mkEndDate = mkEndDate;
    }

    public String getMkPlaceName() {
        return mkPlaceName;
    }

    public void setMkPlaceName(String mkPlaceName) {
        this.mkPlaceName = mkPlaceName;
    }

    public String getMkProduct() {
        return mkProduct;
    }

    public void setMkProduct(String mkProduct) {
        this.mkProduct = mkProduct;
    }

    public String getMkOriMain() {
        return mkOriMain;
    }

    public void setMkOriMain(String mkOriMain) {
        this.mkOriMain = mkOriMain;
    }

    public String getMkFileMain() {
        return mkFileMain;
    }

    public void setMkFileMain(String mkFileMain) {
        this.mkFileMain = mkFileMain;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public String toString() {
        return "MarketingDTO{" +
                "mkNum=" + mkNum +
                ", mkName='" + mkName + '\'' +
                ", mkStartDate=" + mkStartDate +
                ", mkEndDate=" + mkEndDate +
                ", mkPlaceName='" + mkPlaceName + '\'' +
                ", mkProduct='" + mkProduct + '\'' +
                ", mkOriMain='" + mkOriMain + '\'' +
                ", mkFileMain='" + mkFileMain + '\'' +
                ", companyName='" + companyName + '\'' +
                '}';
    }
}
