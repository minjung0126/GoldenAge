package com.goldenage.project.space.model.dto;

import java.util.List;

public class SpaceDTO {

    private int spaceNum; //고유숫자
    private String spaceName; //연습실명
    private String spaceAdd; //연습실 주소
    private String spaceContent; //연습실 소개
    private String spaceWidth; //연습실 크기
    private String spaceTime; //영업시간
    private String spaceLink; //연습실예약사이트
    private List<SpacePhoDTO> photo; //연습실사진

    public SpaceDTO() {
    }

    public SpaceDTO(int spaceNum, String spaceName, String spaceAdd, String spaceContent, String spaceWidth, String spaceTime, String spaceLink, List<SpacePhoDTO> photo) {
        this.spaceNum = spaceNum;
        this.spaceName = spaceName;
        this.spaceAdd = spaceAdd;
        this.spaceContent = spaceContent;
        this.spaceWidth = spaceWidth;
        this.spaceTime = spaceTime;
        this.spaceLink = spaceLink;
        this.photo = photo;
    }

    public int getSpaceNum() {
        return spaceNum;
    }

    public void setSpaceNum(int spaceNum) {
        this.spaceNum = spaceNum;
    }

    public String getSpaceName() {
        return spaceName;
    }

    public void setSpaceName(String spaceName) {
        this.spaceName = spaceName;
    }

    public String getSpaceAdd() {
        return spaceAdd;
    }

    public void setSpaceAdd(String spaceAdd) {
        this.spaceAdd = spaceAdd;
    }

    public String getSpaceContent() {
        return spaceContent;
    }

    public void setSpaceContent(String spaceContent) {
        this.spaceContent = spaceContent;
    }

    public String getSpaceWidth() {
        return spaceWidth;
    }

    public void setSpaceWidth(String spaceWidth) {
        this.spaceWidth = spaceWidth;
    }

    public String getSpaceTime() {
        return spaceTime;
    }

    public void setSpaceTime(String spaceTime) {
        this.spaceTime = spaceTime;
    }

    public String getSpaceLink() {
        return spaceLink;
    }

    public void setSpaceLink(String spaceLink) {
        this.spaceLink = spaceLink;
    }

    public List<SpacePhoDTO> getPhoto() {
        return photo;
    }

    public void setPhoto(List<SpacePhoDTO> photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "SpaceDTO{" +
                "spaceNum=" + spaceNum +
                ", spaceName='" + spaceName + '\'' +
                ", spaceAdd='" + spaceAdd + '\'' +
                ", spaceContent='" + spaceContent + '\'' +
                ", spaceWidth='" + spaceWidth + '\'' +
                ", spaceTime='" + spaceTime + '\'' +
                ", spaceLink='" + spaceLink + '\'' +
                ", photo=" + photo +
                '}';
    }
}
