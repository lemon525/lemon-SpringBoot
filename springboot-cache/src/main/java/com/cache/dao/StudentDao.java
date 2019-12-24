package com.cache.dao;

import com.cache.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface StudentDao {

    @Select("select id,name,gender from student where id = #{id}")
    Student findById(Integer id);
}
