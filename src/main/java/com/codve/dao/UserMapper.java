package com.codve.dao;

import com.codve.model.User;

import java.util.List;

public interface UserMapper {

    int save(User user);

    int update(User user);

    User findById(Long id);

    List<User> find(User user);

    int deleteById(Long id);
}
