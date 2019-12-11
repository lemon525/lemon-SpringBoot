package com.mybatis.entity;

import lombok.Data;

import java.util.List;

@Data
public class User {

        private Integer id;
        private String username;
        private String password;
        private List<Role> roleList;
}
