package com.cache.serviceImpl;

import com.cache.dao.StudentDao;
import com.cache.entity.Student;
import com.cache.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentDao studentDao;

    @Override
    public Student getStudent(Integer id) {
        return studentDao.findById(id);
    }

    @Override
    public void updateStudent(Student student) {
        studentDao.updateGenderById(student);
    }

    @Override
    public void deleteById(Integer id) {
        studentDao.deleteById(id);
    }
}
