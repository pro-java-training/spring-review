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

    @GetMapping("/find")
    public CommonResult<User> findByIdRequestParam(@RequestParam(name = "id") Long id) {
        return findById(id);
    }

    @GetMapping("/find/{id}")
    public CommonResult<User> findByIdPathParam(@PathVariable Long id) {
        return findById(id);
    }

    private CommonResult<User> findById(Long id) {
        Optional<User> userOptional = userService.findById(id);
        return userOptional.map(CommonResult::success).orElseGet(() -> CommonResult.errorNull(EX.E_1104));
    }

    @PostMapping("/save")
    public CommonResult save(@RequestBody User user) {
        long time = Instant.now().getEpochSecond();
        user.setCreateTime(time);
        user.setUpdateTime(time);
        int rs = userService.save(user);
        return rs == 1 ? CommonResult.success() : CommonResult.error(EX.E_1101);
    }
}
