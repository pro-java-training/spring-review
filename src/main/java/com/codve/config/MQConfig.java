package com.codve.config;

import com.codve.mq.Receiver;
import com.codve.mq.Sender;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author admin
 * @date 2020/4/26 15:47
 */
@Configuration
public class MQConfig {

    @Bean
    public Queue queue() {
        return new Queue("test");
    }

    @Bean
    public Receiver receiver() {
        return new Receiver();
    }

    @Bean
    public Sender sender() {
        return new Sender();
    }
}
