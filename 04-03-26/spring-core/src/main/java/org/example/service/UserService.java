package org.example.service;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.example.repository.UserRepository;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import java.util.logging.Logger;


public class UserService implements InitializingBean, DisposableBean {
    private final UserRepository userRepository;
    private static final Logger logger= Logger.getLogger(UserService.class.getName());
    public UserService(UserRepository userRepository) {
        logger.info("Bean 2 created {UserService}");
        this.userRepository=userRepository;
    }
    @PostConstruct
    public void postConstruct(){

        logger.info("Executing @PostConstruct");
    }
    @Override
    public void afterPropertiesSet(){
        logger.info("InitialingBean executed");
    }
    public void registerUser(){
        System.out.println("User is registered");
        userRepository.saveUser();

    }
    @PreDestroy
    public void preDestroy(){
        logger.info("Executing @PreDestroy");
    }
    @Override
    public void destroy(){
        logger.info("DisposableBean executed");
    }

}