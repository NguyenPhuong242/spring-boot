package com.springboot.demo.config;

import com.springboot.demo.my_app.common.Coach;
import com.springboot.demo.my_app.common.ConfigCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AllConfig {
    @Bean("configCoach")
    public Coach configCoach() {
        return new ConfigCoach();
    }

}
