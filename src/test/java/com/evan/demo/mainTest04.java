package com.evan.demo;

import com.evan.config.MainConfig04;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Arrays;


public class mainTest04 {

    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig04.class);

    @Test
    public void test(){
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        Arrays.stream(beanDefinitionNames).forEach(System.out::println);

        // 获得当前的操作系统
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        String property = environment.getProperty("os.name");
        System.out.println("当前系统为：" + property);
    }
}
