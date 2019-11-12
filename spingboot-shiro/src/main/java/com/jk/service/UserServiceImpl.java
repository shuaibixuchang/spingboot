package com.jk.service;

import com.jk.dao.UserMapper;
import com.jk.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService{

    @Resource
    private UserMapper userMapper;

    @Override
    public User queryUserByName(String username) {

        return userMapper.queryUserByName(username);
    }
}
