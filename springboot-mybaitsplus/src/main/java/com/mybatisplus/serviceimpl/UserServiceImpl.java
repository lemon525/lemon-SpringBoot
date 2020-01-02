package com.mybatisplus.serviceimpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mybatisplus.dao.UserDao;
import com.mybatisplus.entity.User;
import com.mybatisplus.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {

}
