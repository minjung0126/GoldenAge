package com.goldenage.project.marketing.model.dto;

public class MkItemDTO {

    private int mkNum;
    private int itemFileNum;
    private String itemOriName;
    private String itemFileName;
    private String itemName;

    public MkItemDTO() {
    }

    public MkItemDTO(int mkNum, int itemFileNum, String itemOriName, String itemFileName, String itemName) {
        this.mkNum = mkNum;
        this.itemFileNum = itemFileNum;
        this.itemOriName = itemOriName;
        this.itemFileName = itemFileName;
        this.itemName = itemName;
    }

    public int getMkNum() {
        return mkNum;
    }

    public void setMkNum(int mkNum) {
        this.mkNum = mkNum;
    }

    public int getItemFileNum() {
        return itemFileNum;
    }

    public void setItemFileNum(int itemFileNum) {
        this.itemFileNum = itemFileNum;
    }

    public String getItemOriName() {
        return itemOriName;
    }

    public void setItemOriName(String itemOriName) {
        this.itemOriName = itemOriName;
    }

    public String getItemFileName() {
        return itemFileName;
    }

    public void setItemFileName(String itemFileName) {
        this.itemFileName = itemFileName;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    @Override
    public String toString() {
        return "MkItemDTO{" +
                "mkNum=" + mkNum +
                ", itemFileNum=" + itemFileNum +
                ", itemOriName='" + itemOriName + '\'' +
                ", itemFileName='" + itemFileName + '\'' +
                ", itemName='" + itemName + '\'' +
                '}';
    }
}
