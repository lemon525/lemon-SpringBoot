package com.cache.dao;

import com.cache.entity.Student;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface StudentDao {

    @Select("select id,name,gender from student where id = #{id}")
    Student findById(Integer id);

    @Update("update student set name = #{name} where id = #{id}")
    void updateGenderById(Student student);

    @Delete("delete from student where id = #{id} ")
    void deleteById(Integer id);
}
