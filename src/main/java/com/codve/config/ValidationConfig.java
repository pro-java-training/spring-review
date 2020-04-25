package com.codve.config;

import com.codve.handler.StringTrimModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author admin
 * @date 2020/4/25 15:10
 */
@Configuration
public class ValidationConfig {

    @Bean
    public StringTrimModule stringTrimModule() {
        return new StringTrimModule();
    }
}
