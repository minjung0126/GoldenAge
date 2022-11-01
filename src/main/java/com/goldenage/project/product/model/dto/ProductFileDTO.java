package com.goldenage.project.product.model.dto;

public class ProductFileDTO {

    private int pd_num;

    private int pdFileNum;

    private String pdOriName;

    private String pdFileName;

    public ProductFileDTO() {
    }

    public ProductFileDTO(int pd_num, int pdFileNum, String pdOriName, String pdFileName) {
        this.pd_num = pd_num;
        this.pdFileNum = pdFileNum;
        this.pdOriName = pdOriName;
        this.pdFileName = pdFileName;
    }

    public int getPd_num() {
        return pd_num;
    }

    public void setPd_num(int pd_num) {
        this.pd_num = pd_num;
    }

    public int getPdFileNum() {
        return pdFileNum;
    }

    public void setPdFileNum(int pdFileNum) {
        this.pdFileNum = pdFileNum;
    }

    public String getPdOriName() {
        return pdOriName;
    }

    public void setPdOriName(String pdOriName) {
        this.pdOriName = pdOriName;
    }

    public String getPdFileName() {
        return pdFileName;
    }

    public void setPdFileName(String pdFileName) {
        this.pdFileName = pdFileName;
    }

    @Override
    public String toString() {
        return "ProductFileDTO{" +
                "pd_num=" + pd_num +
                ", pdFileNum=" + pdFileNum +
                ", pdOriName='" + pdOriName + '\'' +
                ", pdFileName='" + pdFileName + '\'' +
                '}';
    }
}
