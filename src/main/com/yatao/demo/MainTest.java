package com.yatao.demo;

import com.yatao.bean.Blue;
import com.yatao.bean.ColorFactoryBean;
import com.yatao.bean.Person;
import com.yatao.config.MainConfig;
import com.yatao.config.MainConfig2;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;


public class MainTest {


    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
    AnnotationConfigApplicationContext applicationContext2 = new AnnotationConfigApplicationContext(MainConfig2.class);

    private void printBeans(AnnotationConfigApplicationContext context){
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String beanName : beanDefinitionNames){
            System.out.println(beanName);
        }
    }

    @Test
    public void TestColorFactoryBean(){
        printBeans(applicationContext2);
        ColorFactoryBean colorBean = applicationContext2.getBean(ColorFactoryBean.class);
        System.out.println("bean的类型："+colorBean.getClass());
    }

    @Test
    public void testImport(){
        printBeans(applicationContext2);

        Blue blue = applicationContext2.getBean(Blue.class);
        System.out.println(blue);
    }

    @Test
    public void test03(){
        String[] beanDefinitionNames = applicationContext2.getBeanDefinitionNames();
        for (String beanName : beanDefinitionNames){
            System.out.println(beanName);
        }

        // 获得当前的操作系统
        ConfigurableEnvironment environment = applicationContext2.getEnvironment();
        String property = environment.getProperty("os.name");
        System.out.println(property);
    }

    @Test
    public void test01(){

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

    @Test
    public void test02() {
        System.out.println("ioc 容器创建完成。。。。。。");
        Person bean = applicationContext.getBean(Person.class);
        Person bean1 = applicationContext.getBean(Person.class);
        System.out.println(bean);
        System.out.println(bean1);
        System.out.println(bean == bean1);
    }
}
