package com.goldenage.project.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(WebSecurity web) {

        web.ignoring().antMatchers("/css/**", "/js/**", "/images/**", "/lib/**");
    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        // 페이지 접근 권한
//        http.csrf().disable()
//                .authorizeRequests()
//                .anyRequest().permitAll()
//                // 로그인 로그아웃 설정
//                .and()
//                .formLogin()
//                .loginPage("/admin/login")
//                .successForwardUrl("/admin/main")
//                .failureUrl("/admin/failure");
//
//    }
}
