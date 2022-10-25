package com.goldenage.project.login.model.dto;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.List;

public class AdminDTOImpl extends User{

    private int adminNum;
    private String adminName;
    private String adminId;
    private String adminPwd;
    private String adminEmail;
    private int authCode;
    private List<AuthDTO> authDTO;

    public AdminDTOImpl(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public void setDetails(AdminDTO adminDTO) {

        this.adminId = adminDTO.getAdminId();
        this.authCode = adminDTO.getAuthCode();
        this.adminEmail = adminDTO.getAdminEmail();
        this.adminName = adminDTO.getAdminName();
        this.adminNum = adminDTO.getAdminNum();
        this.adminPwd = adminDTO.getAdminPwd();
        this.authDTO = adminDTO.getAuthDTO();
    }

    public int getAdminNum() {
        return adminNum;
    }

    public void setAdminNum(int adminNum) {
        this.adminNum = adminNum;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getAdminPwd() {
        return adminPwd;
    }

    public void setAdminPwd(String adminPwd) {
        this.adminPwd = adminPwd;
    }

    public String getAdminEmail() {
        return adminEmail;
    }

    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }

    public int getAuthCode() {
        return authCode;
    }

    public void setAuthCode(int authCode) {
        this.authCode = authCode;
    }

    public List<AuthDTO> getAuthDTO() {
        return authDTO;
    }

    public void setAuthDTO(List<AuthDTO> authDTO) {
        this.authDTO = authDTO;
    }

    @Override
    public String toString() {
        return "AdminDTO{" +
                "adminNum=" + adminNum +
                ", adminName='" + adminName + '\'' +
                ", adminId='" + adminId + '\'' +
                ", adminPwd='" + adminPwd + '\'' +
                ", adminEmail='" + adminEmail + '\'' +
                ", authCode=" + authCode +
                ", authDTO=" + authDTO +
                '}';
    }


}
