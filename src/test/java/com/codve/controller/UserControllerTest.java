package com.codve.controller;

import com.codve.exception.EX;
import com.codve.model.User;
import com.codve.service.UserService;
import com.codve.util.CommonResult;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

/**
 * @author admin
 * @date 2020/4/25 14:37
 */
@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @Test
    void getUserWhenFindByIdRequestParam() {
        User user = User.builder()
                .name("Alice")
                .password("abcdef")
                .build();
        Optional<User> userOptional = Optional.of(user);
        when(userService.findById(anyLong())).thenReturn(userOptional);
        CommonResult<User> result = userController.findByIdRequestParam(1L);
        assertEquals(user, result.getData());
    }

    @Test
    void getNoUserWhenFindByIdRequestParam() {
        when(userService.findById(anyLong())).thenReturn(Optional.empty());
        CommonResult result = userController.findByIdRequestParam(1L);
        assertEquals(EX.E_1104.getCode(), result.getCode());
    }

    @Test
    void getUserWhenFindByIdPathParam() {
        User user = User.builder()
                .name("Alice")
                .password("abcdef")
                .build();
        when(userService.findById(anyLong())).thenReturn(Optional.of(user));
        CommonResult<User> result = userController.findByIdPathParam(1L);
        assertEquals(user, result.getData());
    }

    @Test
    void getNoUserWhenFindByIdPathParam() {
        when(userService.findById(anyLong())).thenReturn(Optional.empty());
        CommonResult<User> result = userController.findByIdPathParam(1L);
        assertEquals(EX.E_1104.getCode(), result.getCode());
    }

    @Test
    void saveSuccess() {
        when(userService.save(any(User.class))).thenReturn(1);
        CommonResult result = userController.save(new User());
        assertEquals(EX.E_0.getCode(), result.getCode());
    }

    @Test
    void saveFailed() {
        when(userService.save(any(User.class))).thenReturn(0);
        CommonResult result = userController.save(new User());
        assertEquals(EX.E_1101.getCode(), result.getCode());
    }

    @Test
    void updateSuccess() {
        when(userService.update(any(User.class))).thenReturn(1);
        CommonResult result = userController.update(new User());
        assertEquals(EX.E_0.getCode(), result.getCode());
    }

    @Test
    void updateFailed() {
        when(userService.update(any(User.class))).thenReturn(0);
        CommonResult result = userController.update(new User());
        assertEquals(EX.E_1103.getCode(), result.getCode());
    }

    @Test
    void deleteSuccess() {
        when(userService.deleteById(anyLong())).thenReturn(1);
        CommonResult result = userController.delete(1L);
        assertEquals(EX.E_0.getCode(), result.getCode());
    }

    @Test
    void deleteFailed() {
        when(userService.deleteById(anyLong())).thenReturn(0);
        CommonResult result = userController.delete(1L);
        assertEquals(EX.E_1102.getCode(), result.getCode());
    }
}