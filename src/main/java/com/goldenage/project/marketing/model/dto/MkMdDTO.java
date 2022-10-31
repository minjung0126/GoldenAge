package com.goldenage.project.marketing.model.dto;

public class MkMdDTO {

    private int mkNum;
    private int mdFileNum;
    private String mdOriName;
    private String mdFileName;
    private String mdName;
    private String mdPrice;

    public MkMdDTO() {
    }

    public MkMdDTO(int mkNum, int mdFileNum, String mdOriName, String mdFileName, String mdName, String mdPrice) {
        this.mkNum = mkNum;
        this.mdFileNum = mdFileNum;
        this.mdOriName = mdOriName;
        this.mdFileName = mdFileName;
        this.mdName = mdName;
        this.mdPrice = mdPrice;
    }

    public int getMkNum() {
        return mkNum;
    }

    public void setMkNum(int mkNum) {
        this.mkNum = mkNum;
    }

    public int getMdFileNum() {
        return mdFileNum;
    }

    public void setMdFileNum(int mdFileNum) {
        this.mdFileNum = mdFileNum;
    }

    public String getMdOriName() {
        return mdOriName;
    }

    public void setMdOriName(String mdOriName) {
        this.mdOriName = mdOriName;
    }

    public String getMdFileName() {
        return mdFileName;
    }

    public void setMdFileName(String mdFileName) {
        this.mdFileName = mdFileName;
    }

    public String getMdName() {
        return mdName;
    }

    public void setMdName(String mdName) {
        this.mdName = mdName;
    }

    public String getMdPrice() {
        return mdPrice;
    }

    public void setMdPrice(String mdPrice) {
        this.mdPrice = mdPrice;
    }

    @Override
    public String toString() {
        return "MkMdDTO{" +
                "mkNum=" + mkNum +
                ", mdFileNum=" + mdFileNum +
                ", mdOriName='" + mdOriName + '\'' +
                ", mdFileName='" + mdFileName + '\'' +
                ", mdName='" + mdName + '\'' +
                ", mdPrice='" + mdPrice + '\'' +
                '}';
    }
}
