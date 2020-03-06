package com.evan.demo;

import com.evan.bean.Person;
import com.evan.config.MainConfig03;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Description
 * @ClassName mainTest03
 * @Author Evan
 * @date 2020.02.14 16:50
 */
public class mainTest03 {
    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig03.class);

    @Test
    public void test01(){
        System.out.println("ioc 容器创建完成。。。。。。");
        Person bean = applicationContext.getBean(Person.class);
//        Person bean1 = applicationContext.getBean(Person.class);
//        System.out.println(bean);
//        System.out.println(bean1);
//        System.out.println(bean == bean1);
    }

}
