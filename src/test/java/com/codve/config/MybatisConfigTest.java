package com.codve.config;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author admin
 * @date 2020/4/24 17:40
 */
class MybatisConfigTest {

    private MybatisConfig mybatisConfig;

    @Test
    void test() {
        mybatisConfig = new MybatisConfig();
        assertNotNull(mybatisConfig);
    }

}