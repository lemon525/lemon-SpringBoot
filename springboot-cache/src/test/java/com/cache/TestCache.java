package com.cache;

import com.cache.entity.Student;
import com.cache.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;


@SpringBootTest
@RunWith(SpringRunner.class)
public class TestCache {

    @Resource
    private StudentService studentService;

    @Test
    public void test(){
        Student student = studentService.getStudent(1);
        System.out.println("名字是："+student.getName()+"性别是："+student.getGender());
        Student student1 = studentService.getStudent(1);
        System.out.println("名字是："+student1.getName()+"性别是："+student1.getGender());
    }
}
