package org.example.circular;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class B{
    private A a;
    public B(){
        System.out.println("B is created");
    }
    @Autowired
    public void setA(A a){
        System.out.println("A injected into B");
        this.a=a;
    }

}