package com.codve.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author admin
 * @date 2020/4/24 17:19
 */
@ExtendWith(MockitoExtension.class)
class HelloControllerTest {

    private HelloController helloControlle = new HelloController();

    @Test

    void hello() {
        assertEquals("hello, world", helloControlle.hello());
    }

}