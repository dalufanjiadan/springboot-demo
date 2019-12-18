package com.example.springsecurity.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    
    private CustomUserDetailsService userDetailsService;
    
    public CustomAuthenticationSuccessHandler(CustomUserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws IOException, ServletException {

                //生成token，并把token加密相关信息缓存，具体请看实现类
        // String token = userDetailsService.saveUserLoginInfo((UserDetails)authentication.getPrincipal());
        // response.setHeader("Authorization", token);
    }
    
}