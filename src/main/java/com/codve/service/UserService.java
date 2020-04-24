package com.codve.service;

import com.codve.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    int save(User user);

    int update(User user);

    Optional<User> findById(Long id);

    List<User> find(User user);

    int deleteById(Long id);
}
