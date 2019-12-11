package com.mybatis.entity;

import lombok.Data;

import java.util.List;

@Data
public class Role {

    private Integer id;
    private String name;
    private List<User> userList;
}
