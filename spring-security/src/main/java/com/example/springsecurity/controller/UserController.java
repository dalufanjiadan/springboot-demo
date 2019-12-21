package com.example.springsecurity.controller;

import com.example.springsecurity.model.security.RoleName;
import com.example.springsecurity.payload.*;
import com.example.springsecurity.repository.RoleRepository;
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
    RoleRepository roleRepository;

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping("/user/me")
    // @PreAuthorize("hasRole('ROLE_USER')")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    public UserSummary getCurrentUser(@CurrentUser UserPrincipal currentUser) {

        UserSummary userSummary = new UserSummary();
        userSummary.setId(currentUser.getId());
        userSummary.setName(currentUser.getName());
        userSummary.setUsername(currentUser.getUsername());

        boolean isAdmin = currentUser.getAuthorities().stream()
                .anyMatch(o -> o.toString().equals(RoleName.ROLE_ADMIN.toString()));

        userSummary.setAdmin(isAdmin);

        return userSummary;
    }
}