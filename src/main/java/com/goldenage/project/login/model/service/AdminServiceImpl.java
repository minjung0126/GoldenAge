package com.goldenage.project.login.model.service;

import com.goldenage.project.login.model.dao.AdminMapper;
import com.goldenage.project.login.model.dto.AdminDTO;
import com.goldenage.project.login.model.dto.AdminDTOImpl;
import com.goldenage.project.login.model.dto.AuthDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    private AdminMapper adminMapper;

    @Autowired
    public AdminServiceImpl(AdminMapper adminMapper){

        this.adminMapper = adminMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        System.out.println("adminId : " + username);

        AdminDTO adminDTO = adminMapper.selectAdminDTO(username);
        List <AuthDTO> authDTO = adminMapper.selectAuthDTO();
        System.out.println("adminDTO : " + adminDTO);
        System.out.println("authDTO : " + authDTO);

        if(adminDTO == null){
            throw new UsernameNotFoundException("admin not authorized.");
        }

        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        if(authDTO != null){

            for(int i = 0; i < authDTO.size(); i++) {

                if(adminDTO.getAuthCode() == authDTO.get(i).getAuthCode()){

                    authorities.add(new SimpleGrantedAuthority(authDTO.get(i).getAuthName()));
                }
            }
        }

        AdminDTOImpl admin = new AdminDTOImpl(adminDTO.getAdminId(), adminDTO.getAdminPwd(), authorities);
        admin.setDetails(adminDTO);

        return admin;
    }
}
