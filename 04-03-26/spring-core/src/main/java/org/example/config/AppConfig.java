package org.example.config;

import org.example.repository.UserRepository;
import org.example.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
    public class AppConfig{
    @Bean
    public UserRepository userRepository(){
            return new UserRepository();
    }
    @Bean
    public UserService userService(){
        return new UserService(userRepository());
    }
}