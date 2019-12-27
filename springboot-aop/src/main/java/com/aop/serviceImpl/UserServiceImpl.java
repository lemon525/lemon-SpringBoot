package com.aop.serviceImpl;

import com.aop.dao.UserDao;
import com.aop.entity.User;
import com.aop.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;
    @Override
    public User login(User user) {
        return userDao.findByUsername(user);
    }
}
