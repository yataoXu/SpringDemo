package com.listener.learn;


import com.listener.learn.config.HelloEventLinstenerConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HelloEventLinstenerConfigTest {

    @Test
    public void test01() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(HelloEventLinstenerConfig.class);
        // 事件发布
        applicationContext.publishEvent(new HelloEvent(this,"evan"));
        System.out.println("事件发布完成.....");

    }
}
