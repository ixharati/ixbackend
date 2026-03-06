package org.example.client;

import org.example.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

public class GreetingClient {

    @Autowired
    private GreetingService greetingService;

    public void sayHello(){
        greetingService.greet();
    }
    
}
