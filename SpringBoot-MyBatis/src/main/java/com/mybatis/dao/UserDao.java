package com.mybatis.dao;

import com.mybatis.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao {

  List<User> findAll();
}
