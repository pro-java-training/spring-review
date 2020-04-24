package com.codve;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author admin
 * @date 2020/4/24 17:42
 */
class AppTest {

    private App app;

    @Test
    void test() {
        app = new App();
        App.main(new String[]{});

    }

}