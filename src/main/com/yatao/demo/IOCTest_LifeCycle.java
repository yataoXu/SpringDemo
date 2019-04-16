package com.yatao.demo;

import com.yatao.config.MainConfigOfLifeCycle;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOCTest_LifeCycle {

    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);

    @Test
    public void test01() {

    }
}
