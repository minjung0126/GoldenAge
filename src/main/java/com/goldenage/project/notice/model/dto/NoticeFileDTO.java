package com.goldenage.project.notice.model.dto;

public class NoticeFileDTO {

    private int noticeNo; // 공지사항 번호
    private int noticeFileNum; // 파일번호
    private String noticeOriName; // 원본파일명
    private String noticeFileName; // 변경된파일명
    private String savedPath; // 파일저장경로

    public NoticeFileDTO() {
    }

    public NoticeFileDTO(int noticeNo, int noticeFileNum, String noticeOriName, String noticeFileName, String savedPath) {
        this.noticeNo = noticeNo;
        this.noticeFileNum = noticeFileNum;
        this.noticeOriName = noticeOriName;
        this.noticeFileName = noticeFileName;
        this.savedPath = savedPath;
    }

    public int getNoticeNo() {
        return noticeNo;
    }

    public void setNoticeNo(int noticeNo) {
        this.noticeNo = noticeNo;
    }

    public int getNoticeFileNum() {
        return noticeFileNum;
    }

    public void setNoticeFileNum(int noticeFileNum) {
        this.noticeFileNum = noticeFileNum;
    }

    public String getNoticeOriName() {
        return noticeOriName;
    }

    public void setNoticeOriName(String noticeOriName) {
        this.noticeOriName = noticeOriName;
    }

    public String getNoticeFileName() {
        return noticeFileName;
    }

    public void setNoticeFileName(String noticeFileName) {
        this.noticeFileName = noticeFileName;
    }

    public String getSavedPath() {
        return savedPath;
    }

    public void setSavedPath(String savedPath) {
        this.savedPath = savedPath;
    }

    @Override
    public String toString() {
        return "NoticeFileDTO{" +
                "noticeNo=" + noticeNo +
                ", noticeFileNum=" + noticeFileNum +
                ", noticeOriName='" + noticeOriName + '\'' +
                ", noticeFileName='" + noticeFileName + '\'' +
                ", savedPath='" + savedPath + '\'' +
                '}';
    }
}
