package com.example.springsecurity.security;

import java.io.IOException;
import java.nio.charset.Charset;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;
import org.springframework.util.StringUtils;

@Component
public class CustomUsernamePasswordAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    public CustomUsernamePasswordAuthenticationFilter() {

        // 拦截url为 "/login" 的POST请求
        super(new AntPathRequestMatcher("/login", "POST"));
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException, IOException, ServletException {


        System.out.println("-=-=-=-=-=-=-=-=-");
        System.out.println("hello world");
        System.out.println("-=-=-=-=-=-=-=-=-");
                
        // 从json中获取username和password
        String body = StreamUtils.copyToString(request.getInputStream(), Charset.forName("UTF-8"));
        String username = null, password = null;
        if (StringUtils.hasText(body)) {


            System.out.println(body);
            
            // JSONObject
            
            // JSONObject jsonObj = JSON.parseObject(body);
            // username = jsonObj.getString("username");
            // password = jsonObj.getString("password");
        }

        if (username == null)
            username = "";
        if (password == null)
            password = "";
        username = username.trim();
        // 封装到token中提交
        UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username, password);

        return this.getAuthenticationManager().authenticate(authRequest);
    }
}