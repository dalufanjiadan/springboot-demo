package com.example.springsecurity.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * CustomUserDetailsService
 */
public class CustomUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // 真实系统需要从数据库或缓存中获取，这里对密码做了加密
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        return User.builder().username("Jack").password(passwordEncoder.encode("jack-password")).roles("USER").build();
    }

}