package com.goldenage.project.product.model.dto;

import java.util.Date;

public class ProductDTO {

    private int pd_num;
    private String pd_name;
    private Date pd_start_date;
    private Date pd_end_date;
    private String pd_place_name;
    private String pd_rated;
    private String pd_time;
    private String pd_place_add;
    private String company_name;

    public ProductDTO() {
    }

    public ProductDTO(int pd_num, String pd_name, Date pd_start_date, Date pd_end_date, String pd_place_name, String pd_rated, String pd_time, String pd_place_add, String company_name) {
        this.pd_num = pd_num;
        this.pd_name = pd_name;
        this.pd_start_date = pd_start_date;
        this.pd_end_date = pd_end_date;
        this.pd_place_name = pd_place_name;
        this.pd_rated = pd_rated;
        this.pd_time = pd_time;
        this.pd_place_add = pd_place_add;
        this.company_name = company_name;
    }

    public int getPd_num() {
        return pd_num;
    }

    public void setPd_num(int pd_num) {
        this.pd_num = pd_num;
    }

    public String getPd_name() {
        return pd_name;
    }

    public void setPd_name(String pd_name) {
        this.pd_name = pd_name;
    }

    public Date getPd_start_date() {
        return pd_start_date;
    }

    public void setPd_start_date(Date pd_start_date) {
        this.pd_start_date = pd_start_date;
    }

    public Date getPd_end_date() {
        return pd_end_date;
    }

    public void setPd_end_date(Date pd_end_date) {
        this.pd_end_date = pd_end_date;
    }

    public String getPd_place_name() {
        return pd_place_name;
    }

    public void setPd_place_name(String pd_place_name) {
        this.pd_place_name = pd_place_name;
    }

    public String getPd_rated() {
        return pd_rated;
    }

    public void setPd_rated(String pd_rated) {
        this.pd_rated = pd_rated;
    }

    public String getPd_time() {
        return pd_time;
    }

    public void setPd_time(String pd_time) {
        this.pd_time = pd_time;
    }

    public String getPd_place_add() {
        return pd_place_add;
    }

    public void setPd_place_add(String pd_place_add) {
        this.pd_place_add = pd_place_add;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    @Override
    public String toString() {
        return "ProductDto{" +
                "pd_num=" + pd_num +
                ", pd_name='" + pd_name + '\'' +
                ", pd_start_date=" + pd_start_date +
                ", pd_end_date=" + pd_end_date +
                ", pd_place_name='" + pd_place_name + '\'' +
                ", pd_rated='" + pd_rated + '\'' +
                ", pd_time='" + pd_time + '\'' +
                ", pd_place_add='" + pd_place_add + '\'' +
                ", company_name='" + company_name + '\'' +
                '}';
    }
}
