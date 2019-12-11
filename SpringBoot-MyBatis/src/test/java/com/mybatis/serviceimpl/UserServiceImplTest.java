package com.mybatis.serviceimpl;

import com.mybatis.entity.Role;
import com.mybatis.entity.User;
import com.mybatis.service.RoleService;
import com.mybatis.service.UserService;
import lombok.var;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceImplTest {

    @Resource
    private UserService userService;
    @Resource
    private RoleService roleService;


    @Test
    public void findAll() {
        List<User> users = userService.findAll();
        users.forEach(user->{
            System.out.println(user.toString());
        });
    }

    @Test
    public void RoleTestAll(){
        List<Role> roles = roleService.findAll();
        roles.forEach(role -> System.out.println(role.toString()));
    }

    @Test
    public void tessMap(){

    }

}