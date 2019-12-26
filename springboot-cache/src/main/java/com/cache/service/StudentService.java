package com.cache.service;

import com.cache.entity.Student;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

@CacheConfig(cacheNames = "student")
public interface StudentService {

    @Cacheable(key = "#p0")
    Student getStudent(Integer id);

    @CachePut(key = "#p0.id")
    Student updateStudent(Student student);

    @CacheEvict(key = "#p0", allEntries = true)
    void deleteById(Integer id);
}
