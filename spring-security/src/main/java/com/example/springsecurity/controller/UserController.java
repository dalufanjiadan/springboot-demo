package com.example.springsecurity.controller;

import java.util.ArrayList;
import java.util.List;

import com.example.springsecurity.exception.ResourceNotFoundException;
import com.example.springsecurity.model.security.RoleName;
import com.example.springsecurity.model.security.User;
import com.example.springsecurity.payload.*;
import com.example.springsecurity.repository.RoleRepository;
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
    RoleRepository roleRepository;

    @Autowired
    UserRepository userRepository;

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

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/users/{username}")
    public UserProfile getUser(@PathVariable(value = "username") String username) {

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User", "username", username));

        UserProfile userProfile = new UserProfile(user);
        return userProfile;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/users")
    public List<UserProfile> getAll() {

        List<User> users = userRepository.findAll();
        List<UserProfile> result = new ArrayList<>();
        for (User user : users) {
            result.add(new UserProfile(user));
        }

        return result;
    }
}