package com.evan.demo;

import com.evan.config.MainConfig01;
import com.evan.bean.Person;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class mainTest01 {
    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig01.class);

    @Test
    public void test01() {
        printBeans(applicationContext);
        // 根据类型获取
        Person bean = applicationContext.getBean(Person.class);
        System.out.println(bean);

        // 根据类型获取
        String[] beanNamesForType = applicationContext.getBeanNamesForType(Person.class);
        for (String beanName : beanNamesForType) {
            System.out.println(beanName);
        }

        System.out.println("====================");
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanName : beanDefinitionNames) {
            System.out.println(beanName);
        }
    }


    @Test
    public void test02() {
        System.out.println("ioc 容器创建完成。。。。。。");
        Person bean = applicationContext.getBean(Person.class);
        Person bean1 = applicationContext.getBean(Person.class);
        System.out.println(bean); //Person(name=张三, age=18, nickName=${person.nickName})
        System.out.println(bean1); // Person(name=张三, age=18, nickName=${person.nickName})
        System.out.println(bean == bean1); // true
    }

    private void printBeans(AnnotationConfigApplicationContext context) {
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String beanName : beanDefinitionNames) {
            System.out.println(beanName);
        }
    }

}
