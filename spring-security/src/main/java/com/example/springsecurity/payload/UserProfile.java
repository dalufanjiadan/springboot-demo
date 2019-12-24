package com.example.springsecurity.payload;

import java.time.Instant;
import java.util.Set;

import com.example.springsecurity.model.security.Role;
import com.example.springsecurity.model.security.User;

import lombok.Data;

/**
 * UserProfile
 */
@Data
public class UserProfile {

    private Long id;
    private String username;
    private String name;
    private Instant joinedAt;
    private Set<Role> roles;

    public UserProfile(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.name = user.getName();
        this.joinedAt = user.getCreatedAt();
        this.roles = user.getRoles();
    }

}