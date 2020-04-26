package com.codve.mq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author admin
 * @date 2020/4/26 15:45
 */
public class Sender {

    @Autowired
    private AmqpTemplate template;

    @Autowired
    Queue queue;

    public void send(String msg) {
        template.convertAndSend(queue.getName(), msg);
    }
}
