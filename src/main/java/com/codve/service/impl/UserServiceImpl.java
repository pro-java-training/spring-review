package com.codve.service.impl;

import com.codve.dao.UserMapper;
import com.codve.model.User;
import com.codve.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int save(User user) {
        return userMapper.save(user);
    }
}
