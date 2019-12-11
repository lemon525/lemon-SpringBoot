package com.mybatis.dao;

import com.mybatis.entity.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface RoleDao {

    List<Role> findAll();
}
