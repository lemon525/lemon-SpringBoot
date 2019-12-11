package com.mybatis.serviceimpl;

import com.mybatis.dao.UserDao;
import com.mybatis.entity.User;
import com.mybatis.service.UserService;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User findById(Integer id) {
        return null;
    }
}
