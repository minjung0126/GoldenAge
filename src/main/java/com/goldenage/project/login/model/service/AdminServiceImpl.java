package com.goldenage.project.login.model.service;

import com.goldenage.project.login.model.dao.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AdminServiceImpl implements AdminService {

    private AdminMapper adminMapper;

    @Autowired
    public AdminServiceImpl(AdminMapper adminMapper){

        this.adminMapper = adminMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserDetails user = adminMapper.getUsername(username);
        System.out.println("user : " + user);
        if(user == null){
            throw new UsernameNotFoundException("admin not authorized.");
        }
        return user;
    }
}
