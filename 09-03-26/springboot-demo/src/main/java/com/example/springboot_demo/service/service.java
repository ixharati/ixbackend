package com.example.springboot_demo.service;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class service {

    @Value("${name}")
    private String name;

    @Value("${age}")
    private int age;

    @PostConstruct
    public void diplay(){
        System.out.println("Name : "+ name +", Age : "+ age);
    }

}
