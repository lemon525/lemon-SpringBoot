package com.springsecurity.config;

import com.springsecurity.entity.Userinfo;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;

@Configuration
public class UserDetailService implements UserDetailsService {

    @Resource
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Userinfo userinfo = new Userinfo();
        userinfo.setUsername(username);
        userinfo.setPassword(passwordEncoder.encode("123456"));
        System.out.println(userinfo.getPassword());
        Collection<GrantedAuthority> authorities = new ArrayList<>(); // 暂时不添加权限
        return new User(userinfo.getUsername(),userinfo.getPassword(),authorities);
    }
}
