package com.example.casino.config;

import com.example.casino.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public UserService userServiceBean(){

        return new UserService();
    }
}
