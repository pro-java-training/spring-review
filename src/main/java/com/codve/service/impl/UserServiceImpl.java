package com.codve.service.impl;

import com.codve.dao.UserMapper;
import com.codve.model.User;
import com.codve.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

@Service
@CacheConfig(cacheNames = "UserServiceImpl")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    @CacheEvict(allEntries = true)
    public int save(User user) {
        return userMapper.save(user);
    }

    @Override
    @CacheEvict(allEntries = true)
    public int update(User user) {
        return userMapper.update(user);
    }

    @Override
    @Cacheable(unless = "#result == null")
    public Optional<User> findById(Long id) {
        return Optional.ofNullable(userMapper.findById(id));
    }

    @Override
    @Cacheable(unless = "#result.size() == 0")
    public List<User> find(User user) {
        return userMapper.find(user);
    }

    @Override
    @CacheEvict(allEntries = true)
    public int deleteById(Long id) {
        return userMapper.deleteById(id);
    }
}
