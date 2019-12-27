package com.aop.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class LoginLog implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String name;
    private String ip;
    private Date date;
}
