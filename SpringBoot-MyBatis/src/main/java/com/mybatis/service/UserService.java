package com.mybatis.service;

import com.mybatis.entity.User;

import java.util.List;


public interface UserService {

    List<User> findAll();

    User findById(Integer id);
}
