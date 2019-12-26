package com.cache.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Student implements Serializable {

    private Integer id;
    private String name;
    private String gender;
}
