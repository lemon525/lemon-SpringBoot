package com.swagger.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api
public class WebController {

    @GetMapping("/hello")
    @ApiOperation("测试 swagger2")
    public String hello(){
        return "测试 swagger2";
    }

    @GetMapping("/login")
    public String login(){
        return "登录";
    }
}
