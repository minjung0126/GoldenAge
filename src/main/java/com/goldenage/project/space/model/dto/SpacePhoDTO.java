package com.goldenage.project.space.model.dto;

public class SpacePhoDTO {

    private String spaceName; //연습실이름
    private int spaceFileNum; //연습실사진번호
    private String spaceOriName; //원본파일명
    private String spaceFileName; //바뀐파일명

    public SpacePhoDTO() {
    }

    public SpacePhoDTO(String spaceName, int spaceFileNum, String spaceOriName, String spaceFileName) {
        this.spaceName = spaceName;
        this.spaceFileNum = spaceFileNum;
        this.spaceOriName = spaceOriName;
        this.spaceFileName = spaceFileName;
    }

    public String getSpaceName() {
        return spaceName;
    }

    public void setSpaceName(String spaceName) {
        this.spaceName = spaceName;
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
                "spaceName='" + spaceName + '\'' +
                ", spaceFileNum=" + spaceFileNum +
                ", spaceOriName='" + spaceOriName + '\'' +
                ", spaceFileName='" + spaceFileName + '\'' +
                '}';
    }
}

