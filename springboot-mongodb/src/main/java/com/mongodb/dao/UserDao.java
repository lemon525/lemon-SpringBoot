package com.mongodb.dao;

import com.mongodb.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserDao extends MongoRepository<User,Integer> {
    User findByUsername(String username);
}
