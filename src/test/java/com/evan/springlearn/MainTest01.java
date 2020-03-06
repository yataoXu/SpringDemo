package com.evan.springlearn;

import com.evan.bean.Blue;
import com.evan.bean.ColorFactoryBean;
import com.evan.bean.Person;
import com.evan.config.MainConfig;
import com.evan.config.MainConfig2;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;


public class MainTest01 {


    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
    AnnotationConfigApplicationContext applicationContext2 = new AnnotationConfigApplicationContext(MainConfig2.class);

    private void printBeans(AnnotationConfigApplicationContext context) {
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String beanName : beanDefinitionNames) {
            System.out.println(beanName);
        }
    }

    @Test
    public void Test05() {
//        printBeans(applicationContext2);
        ColorFactoryBean colorBean = applicationContext2.getBean(ColorFactoryBean.class);
        //ColorFactoryBean 获得的是调用 gebBean () 产生的对象
        System.out.println("bean的类型：" + colorBean.getClass());

        Object bean2 = applicationContext2.getBean("colorFactoryBean");
        Object bean3 = applicationContext2.getBean("colorFactoryBean");
        System.out.println("bean的类型：" + bean2.getClass());
        System.out.println(bean2 == bean3);

        Object bean4 = applicationContext2.getBean("&colorFactoryBean");
        System.out.println(bean4.getClass());


    }

    @Test
    public void test04() {
        printBeans(applicationContext2);

        Blue blue = applicationContext2.getBean(Blue.class);
        System.out.println(blue);
    }

    @Test
    public void test03() {
        String[] beanDefinitionNames = applicationContext2.getBeanDefinitionNames();
        for (String beanName : beanDefinitionNames) {
            System.out.println(beanName);
        }

        // 获得当前的操作系统
        ConfigurableEnvironment environment = applicationContext2.getEnvironment();
        String property = environment.getProperty("os.name");
        System.out.println(property);
    }


    @Test
    public void test02() {
        System.out.println("ioc 容器创建完成。。。。。。");
        Person bean = applicationContext.getBean(Person.class);
        Person bean1 = applicationContext.getBean(Person.class);
        System.out.println(bean);
        System.out.println(bean1);
        System.out.println(bean == bean1);
    }

    @Test
    public void test01() {


        applicationContext.scan("com.evan.controller");
        printBeans(applicationContext);
        Person bean = applicationContext.getBean(Person.class);
        System.out.println(bean);

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
}
