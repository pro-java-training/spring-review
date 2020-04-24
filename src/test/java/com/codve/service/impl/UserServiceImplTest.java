package com.codve.service.impl;

import com.codve.dao.UserMapper;
import com.codve.model.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    private UserMapper userMapper;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    void save() {
        when(userMapper.save(any(User.class))).thenReturn(1);
        assertEquals(1, userService.save(new User()));
    }

    @Test
    void update() {
        when(userMapper.update(any(User.class))).thenReturn(1);
        assertEquals(1, userService.update(new User()));
    }

    @Test
    void findById() {
        when(userMapper.findById(anyLong())).thenReturn(mock(User.class));
        assertNotNull(userService.findById(1L));
    }

    @Test
    void find() {
        when(userMapper.find(any(User.class))).thenReturn(Collections.singletonList(mock(User.class)));
        assertEquals(1, userService.find(new User()).size());
    }

    @Test
    void deleteById() {
        when(userMapper.deleteById(anyLong())).thenReturn(1);
        assertEquals(1, userService.deleteById(1L));
    }
}