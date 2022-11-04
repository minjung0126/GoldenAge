package com.goldenage.project.product.model.dto;

public class ProductDetailDTO {

    private int pd_num;

    private int detail_file_num;

    private String detail_ori_name;

    private String detail_file_name;

    public ProductDetailDTO() {
    }

    public ProductDetailDTO(int pd_num, int detail_file_num, String detail_ori_name, String detail_file_name) {
        this.pd_num = pd_num;
        this.detail_file_num = detail_file_num;
        this.detail_ori_name = detail_ori_name;
        this.detail_file_name = detail_file_name;
    }

    public int getPd_num() {
        return pd_num;
    }

    public void setPd_num(int pd_num) {
        this.pd_num = pd_num;
    }

    public int getDetail_file_num() {
        return detail_file_num;
    }

    public void setDetail_file_num(int detail_file_num) {
        this.detail_file_num = detail_file_num;
    }

    public String getDetail_ori_name() {
        return detail_ori_name;
    }

    public void setDetail_ori_name(String detail_ori_name) {
        this.detail_ori_name = detail_ori_name;
    }

    public String getDetail_file_name() {
        return detail_file_name;
    }

    public void setDetail_file_name(String detail_file_name) {
        this.detail_file_name = detail_file_name;
    }

    @Override
    public String toString() {
        return "ProductFileDTO{" +
                "pd_num=" + pd_num +
                ", detail_file_num=" + detail_file_num +
                ", detail_ori_name='" + detail_ori_name + '\'' +
                ", detail_file_name='" + detail_file_name + '\'' +
                '}';
    }
}
