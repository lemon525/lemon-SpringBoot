package com.lemon.springboot.controller;

import com.lemon.springboot.dto.UserDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api
public class WebController {

    @GetMapping("/test")
    @ApiOperation("测试")
    public String test() {
        return "test";
    }

    @PostMapping("/saveUser")
    @ApiOperation("添加用户")
    public UserDto saveUser(@RequestBody @Validated UserDto userDto) {
        return userDto;
    }
}
