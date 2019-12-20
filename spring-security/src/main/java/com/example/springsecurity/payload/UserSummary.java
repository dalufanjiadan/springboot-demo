package com.example.springsecurity.payload;

import lombok.Data;

/**
 * UserSummary
 */
@Data
public class UserSummary {

    private Long id;
    private String name;
    private String username;
    private boolean isAdmin;
}