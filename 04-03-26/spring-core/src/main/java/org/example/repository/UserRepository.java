package org.example.repository;
import java.util.logging.Logger;

public class UserRepository{
    private static final Logger logger= Logger.getLogger(UserRepository.class.getName());
    public UserRepository(){
        logger.info("Bean 1 created {UserRepository}");
    }
    public void saveUser(){

        System.out.println("Saved the user");
    }
}