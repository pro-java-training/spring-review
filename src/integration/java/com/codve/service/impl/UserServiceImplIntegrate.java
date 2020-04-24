package com.codve.service.impl;

import com.codve.model.User;
import com.codve.service.UserService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author admin
 * @date 2020/4/24 16:16
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
class UserServiceImplIntegrate {

    @Autowired
    private UserService userService;

    @Autowired
    private DataSource dataSource;

    private static ResourceDatabasePopulator populator;

    @BeforeAll
    static void setUpAll() {
        populator = new ResourceDatabasePopulator();
        populator.addScript(new ClassPathResource("db/user_data.sql"));
    }

    @BeforeEach
    void setUp() {
        populator.execute(dataSource);
    }

    @Test
    void add() {
        User user = User.builder()
                .name("Jimmy")
                .password("123456")
                .createTime(Instant.now().getEpochSecond())
                .updateTime(Instant.now().getEpochSecond())
                .build();
        assertEquals(1, userService.save(user));
    }

    @Test
    void update() {
        Optional<User> userOptional = userService.findById(1L);
        assertTrue(userOptional.isPresent());
        User user = userOptional.get();
        user.setName("Williams");
        assertEquals(1, userService.update(user));
    }

    @Test
    void findById() {
        List<User> users = userService.find(User.builder().name("A").build());
        assertEquals(1, users.size());
    }
}