package com.evan.bean;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


@Component
public class Dog {

    public Dog(){
        System.out.println("dog constructor ....");
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("dog constructor ....postConstruct....");
    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("dog constructor ....preDestroy....");
    }

}
