package com.codve.controller;

import com.codve.exception.EX;
import com.codve.model.User;
import com.codve.service.UserService;
import com.codve.util.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.Optional;

/**
 * @author admin
 * @date 2020/4/24 18:42
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/find/{id}")
    public CommonResult<User> findById(@PathVariable Long id) {
        Optional<User> userOptional = userService.findById(id);
        return userOptional.map(CommonResult::success).orElseGet(() -> CommonResult.errorNull(EX.E_1104));
    }

    @GetMapping("/find")
    public CommonResult<User> findByIdRequestParam(@RequestParam(name = "id") Long id) {
        Optional<User> userOptional = userService.findById(id);
        return userOptional.map(CommonResult::success).orElseGet(() -> CommonResult.errorNull(EX.E_1104));
    }

    @GetMapping("/save")
    public CommonResult save() {
        User user = User.builder()
                .name("Sally")
                .password("qwerty")
                .createTime(Instant.now().getEpochSecond())
                .updateTime(Instant.now().getEpochSecond())
                .build();
        int rs = userService.save(user);
        if (rs == 1) {
            return CommonResult.success();
        }
        return CommonResult.error(EX.E_1101);
    }
}
