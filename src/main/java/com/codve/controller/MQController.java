package com.codve.controller;

import com.codve.model.User;
import com.codve.mq.Sender;
import com.codve.util.CommonResult;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author admin
 * @date 2020/4/26 15:49
 */
@RestController
@RequestMapping("/mq")
public class MQController {

    @Autowired
    private Sender sender;

    @Autowired
    private ObjectMapper objectMapper;

    @GetMapping("/send/{msg}")
    public CommonResult send(@PathVariable String msg) {
        sender.send(msg);
        return CommonResult.success();
    }

    @PostMapping("/send")
    public CommonResult send(@RequestBody User user) {
        try {
            sender.send(objectMapper.writeValueAsString(user));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return CommonResult.success();
    }
}
