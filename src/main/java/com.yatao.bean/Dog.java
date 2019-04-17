package com.yatao.bean;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @ Author : Evan.
 * @ Description :
 * @ Date : Crreate in 2019/4/17 10:44
 * @Mail : xuyt@zendaimoney.com
 */
@Component
public class Dog implements ApplicationContextAware {

    private ApplicationContext applicationContext;

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

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
