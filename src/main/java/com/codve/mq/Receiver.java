package com.codve.mq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

/**
 * @author admin
 * @date 2020/4/26 15:46
 */
@Slf4j
@RabbitListener(queues = "test")
public class Receiver {

    @RabbitHandler
    public void handle(String msg) {
        log.warn(msg);
    }
}
