package com.evan;

import com.evan.config.MainConifgOfAutowired;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOCTest_Autowired {

    @Test
    public void test01() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConifgOfAutowired.class);
        System.out.println("容器创建完成。。。");
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanName : beanDefinitionNames) {
            System.out.println(beanName);
        }

        //关闭容器
        applicationContext.close();
    }
}
