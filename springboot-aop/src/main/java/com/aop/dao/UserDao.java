package com.aop.dao;

import com.aop.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserDao {

    @Select("select * from user where username = #{username} and password = #{password}")
    User findByUsername(User user);
}
