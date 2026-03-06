package org.example.circular;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
    public class CircularConfig{

    @Bean
    public A a(){
        return new A();
    }
    @Bean
    public B b(){
        return new B();
    }

    }