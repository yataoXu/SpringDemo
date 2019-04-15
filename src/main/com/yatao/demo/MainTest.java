package com.yatao.demo;

import com.yatao.bean.Person;
import com.yatao.config.MainConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class MainTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        Person bean = applicationContext.getBean(Person.class);
        System.out.println(bean);
    }
}
