package com.example.springsecurity.controller;

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
@RequestMapping("/test")
public class TestController {

    @GetMapping("/hello")
    @ApiOperation(value = "hello", notes = "hello world")
    public String hello() {
        return "hello world";
    }

}