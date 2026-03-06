package org.example.config;

import org.example.client.GreetingClient;
import org.example.service.GreetingService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public GreetingService greetingService(){
        return new GreetingService();
    }
    @Bean
    public GreetingClient greetingClient(){
        return new GreetingClient();
    }
}
