package org.example.circular;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppCircular {
    public static void main() {
        ApplicationContext context =new AnnotationConfigApplicationContext(CircularConfig.class);

    }
}