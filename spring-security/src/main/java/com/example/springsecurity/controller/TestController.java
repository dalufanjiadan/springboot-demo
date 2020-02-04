package com.example.springsecurity.controller;

import com.example.springsecurity.security.CurrentUser;
import com.example.springsecurity.security.UserPrincipal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

/**
 * TestController
 */
@Api(tags = "0 Test")
@RestController
@RequestMapping("/api/test")
// @PreAuthorize("hasRole('ROLE_USER')")
public class TestController {
    
    @GetMapping("/hello")
    @ApiOperation(value = "hello", notes = "hello world")
    // TODO
    public String hello(@CurrentUser UserPrincipal currentUser) {


        System.out.println("-=-=-");
        // TODO
        System.out.println(currentUser);

        System.out.println("hello world");
        System.out.println("-=-=-");
        
        return "hello world";
    }

}