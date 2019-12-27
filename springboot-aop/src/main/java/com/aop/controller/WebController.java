package com.aop.controller;

import com.aop.entity.User;
import com.aop.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class WebController {

    @Resource
    private UserService userService;

    @PostMapping("/login")
    public String login(User user){
        return "登录接口";
    }
}
