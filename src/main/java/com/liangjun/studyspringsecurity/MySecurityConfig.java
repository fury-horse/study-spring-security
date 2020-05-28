package com.liangjun.studyspringsecurity;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
* @desc    security配置
* @version 1.0
* @author  Liang Jun
* @date    2020年05月12日 00:03:52
**/
//@EnableWebSecurity
//@Configuration
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().authenticated()
            .and().formLogin()
                .loginPage("/login.html").permitAll()
                .loginProcessingUrl("/userLogin")
                //指定成功页面
                .defaultSuccessUrl("/loginOk.html", true)
                //指定错误页面
                .failureUrl("/error.html")

                //指定错误回调
                .failureHandler(new AuthenticationFailureHandler() {
                    @Override
                    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
                        e.printStackTrace();
                    }
                })
                //指定成功回调
                .successHandler(new AuthenticationSuccessHandler() {
                    @Override
                    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
                        System.out.println("登录成功");
                        // 根据权限不同，跳转到不同页面
                        request.getSession().getAttribute("userName");
                        request.getRequestDispatcher("").forward(request, response);
                    }
                })

            //禁用csrf防范
            .and().csrf().disable()
        ;
    }
}