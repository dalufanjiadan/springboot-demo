package com.example.springsecurity.controller;

import com.example.springsecurity.exception.ResourceNotFoundException;
import com.example.springsecurity.model.security.RoleName;
import com.example.springsecurity.payload.*;
import com.example.springsecurity.repository.UserRepository;
import com.example.springsecurity.security.UserPrincipal;
import com.example.springsecurity.security.CurrentUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping("/user/me")
    @PreAuthorize("hasRole('USER')")
    public UserSummary getCurrentUser(@CurrentUser UserPrincipal currentUser) {
        UserSummary userSummary = new UserSummary();

        System.out.println("-=-=-=-=-=-=");
        System.out.println(currentUser);

        System.out.println(currentUser.getId());
        System.out.println("-=-=-=-=-=-=");

        userSummary.setId(currentUser.getId());
        userSummary.setName(currentUser.getName());
        userSummary.setUsername(currentUser.getUsername());

        ;
        System.out.println(currentUser.getAuthorities().contains(RoleName.ROLE_USER));

        userSummary.setAdmin(isAdmin());

        return userSummary;
    }

    @PreAuthorize("hasRole('USER')")
    private boolean isAdmin() {
        return true;
    }
}