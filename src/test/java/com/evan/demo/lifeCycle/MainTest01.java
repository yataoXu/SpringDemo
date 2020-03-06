package com.evan.demo.lifeCycle;

import com.evan.config.lifeCycle.MainConfig01;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainTest01 {
    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig01.class);

    @Test
    public void test01() {
        System.out.println("容器创建完成。。。");
        //关闭容器
        applicationContext.close();
    }
}
