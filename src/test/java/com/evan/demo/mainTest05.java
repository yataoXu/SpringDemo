package com.evan.demo;

import com.evan.config.MainConfig05;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class mainTest05 {

    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig05.class);

    @Test
    public void test() {
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        Arrays.stream(beanDefinitionNames).forEach(System.out::println);
    }
}
