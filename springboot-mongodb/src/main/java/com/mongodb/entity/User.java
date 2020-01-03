package com.mongodb.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;


import java.util.Date;

@Data
public class User {

    @Id
    private Integer id;
    private String username;
    private String password;
    private Date createTime;
    private Userinfo userinfo;
}
