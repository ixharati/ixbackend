package org.example.circular;
import org.springframework.beans.factory.annotation.Autowired;

public class A{
    private B b;
    public A(){
        System.out.println("A is created");
    }
    @Autowired
    public void setB(B a){
        System.out.println("B injected into A");
        this.b =b;
    }

}