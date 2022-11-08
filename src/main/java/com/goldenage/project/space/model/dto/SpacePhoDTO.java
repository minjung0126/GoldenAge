package com.goldenage.project.space.model.dto;

public class SpacePhoDTO {

    private int spaceNum; //연습실고유번호
    private int spaceFileNum; //연습실사진번호
    private String spaceOriName; //원본파일명
    private String spaceFileName; //바뀐파일명

    public SpacePhoDTO() {
    }

    public SpacePhoDTO(int spaceNum, int spaceFileNum, String spaceOriName, String spaceFileName) {
        this.spaceNum = spaceNum;
        this.spaceFileNum = spaceFileNum;
        this.spaceOriName = spaceOriName;
        this.spaceFileName = spaceFileName;
    }

    public int getSpaceNum() {
        return spaceNum;
    }

    public void setSpaceNum(int spaceNum) {
        this.spaceNum = spaceNum;
    }

    public int getSpaceFileNum() {
        return spaceFileNum;
    }

    public void setSpaceFileNum(int spaceFileNum) {
        this.spaceFileNum = spaceFileNum;
    }

    public String getSpaceOriName() {
        return spaceOriName;
    }

    public void setSpaceOriName(String spaceOriName) {
        this.spaceOriName = spaceOriName;
    }

    public String getSpaceFileName() {
        return spaceFileName;
    }

    public void setSpaceFileName(String spaceFileName) {
        this.spaceFileName = spaceFileName;
    }

    @Override
    public String toString() {
        return "SpacePhoDTO{" +
                "spaceNum=" + spaceNum +
                ", spaceFileNum=" + spaceFileNum +
                ", spaceOriName='" + spaceOriName + '\'' +
                ", spaceFileName='" + spaceFileName + '\'' +
                '}';
    }
}

