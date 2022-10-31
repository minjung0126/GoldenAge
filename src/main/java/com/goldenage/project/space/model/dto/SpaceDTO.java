package com.goldenage.project.space.model.dto;

public class SpaceDTO {

    private String spaceName; //연습실명
    private String spaceAdd; //연습실 주소
    private String spaceWidth; //연습실 크기
    private String spaceTime; //영업시간
    private String spaceHDay; //휴무일
    private int spacePrice; //연습실 대여비
    private SpacePhoDTO photo; //연습실사진

    public SpaceDTO() {
    }

    public SpaceDTO(String spaceName, String spaceAdd, String spaceWidth, String spaceTime, String spaceHDay, int spacePrice, SpacePhoDTO photo) {
        this.spaceName = spaceName;
        this.spaceAdd = spaceAdd;
        this.spaceWidth = spaceWidth;
        this.spaceTime = spaceTime;
        this.spaceHDay = spaceHDay;
        this.spacePrice = spacePrice;
        this.photo = photo;
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

    public String getSpaceHDay() {
        return spaceHDay;
    }

    public void setSpaceHDay(String spaceHDay) {
        this.spaceHDay = spaceHDay;
    }

    public int getSpacePrice() {
        return spacePrice;
    }

    public void setSpacePrice(int spacePrice) {
        this.spacePrice = spacePrice;
    }

    public SpacePhoDTO getPhoto() {
        return photo;
    }

    public void setPhoto(SpacePhoDTO photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "SpaceDTO{" +
                "spaceName='" + spaceName + '\'' +
                ", spaceAdd='" + spaceAdd + '\'' +
                ", spaceWidth='" + spaceWidth + '\'' +
                ", spaceTime='" + spaceTime + '\'' +
                ", spaceHDay='" + spaceHDay + '\'' +
                ", spacePrice=" + spacePrice +
                ", photo=" + photo +
                '}';
    }
}
