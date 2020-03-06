package com.evan.demo;


import com.evan.config.MainConfig02;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class mainTest02 {

    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig02.class);

    @Test
    public void test02() {
        System.out.println("ioc 容器创建完成。。。。。。");
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanName : beanDefinitionNames) {
            System.out.println(beanName);
        }
    }
}
