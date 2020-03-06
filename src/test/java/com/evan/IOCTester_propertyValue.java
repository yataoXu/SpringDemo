package com.evan;

import com.evan.config.MainConfigOfPropertyValues;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @ Author : Evan.
 * @ Description :
 * @ Date : Crreate in 2019/4/17 11:29
 * @Mail : xuyt@zendaimoney.com
 */
public class IOCTester_propertyValue {


    @Test
    public void test01(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfPropertyValues.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanName : beanDefinitionNames) {
            System.out.println(beanName);
        }
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        String property = environment.getProperty("person.nickName");
        System.out.println(property);
    }
}
