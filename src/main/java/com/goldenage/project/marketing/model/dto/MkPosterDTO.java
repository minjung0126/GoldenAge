package com.goldenage.project.marketing.model.dto;

public class MkPosterDTO {

    private int mkNum;
    private int pFileNum;
    private String pOriName;
    private String pFileName;
    private String pActName;
    private String pCastName;

    public MkPosterDTO() {
    }

    public MkPosterDTO(int mkNum, int pFileNum, String pOriName, String pFileName, String pActName, String pCastName) {
        this.mkNum = mkNum;
        this.pFileNum = pFileNum;
        this.pOriName = pOriName;
        this.pFileName = pFileName;
        this.pActName = pActName;
        this.pCastName = pCastName;
    }

    public int getMkNum() {
        return mkNum;
    }

    public void setMkNum(int mkNum) {
        this.mkNum = mkNum;
    }

    public int getpFileNum() {
        return pFileNum;
    }

    public void setpFileNum(int pFileNum) {
        this.pFileNum = pFileNum;
    }

    public String getpOriName() {
        return pOriName;
    }

    public void setpOriName(String pOriName) {
        this.pOriName = pOriName;
    }

    public String getpFileName() {
        return pFileName;
    }

    public void setpFileName(String pFileName) {
        this.pFileName = pFileName;
    }

    public String getpActName() {
        return pActName;
    }

    public void setpActName(String pActName) {
        this.pActName = pActName;
    }

    public String getpCastName() {
        return pCastName;
    }

    public void setpCastName(String pCastName) {
        this.pCastName = pCastName;
    }

    @Override
    public String toString() {
        return "PosterDTO{" +
                "mkNum=" + mkNum +
                ", pFileNum=" + pFileNum +
                ", pOriName='" + pOriName + '\'' +
                ", pFileName='" + pFileName + '\'' +
                ", pActName='" + pActName + '\'' +
                ", pCastName='" + pCastName + '\'' +
                '}';
    }
}
