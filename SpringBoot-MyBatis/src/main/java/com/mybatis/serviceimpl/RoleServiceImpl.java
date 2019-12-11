package com.mybatis.serviceimpl;

import com.mybatis.dao.RoleDao;
import com.mybatis.entity.Role;
import com.mybatis.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleDao roleDao;
    @Override
    public List<Role> findAll() {
        return roleDao.findAll();
    }
}
