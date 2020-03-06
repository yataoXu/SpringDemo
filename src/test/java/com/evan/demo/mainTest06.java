package com.evan.demo;

import com.evan.config.MainConfig06;
import com.evan.service.ColorFactoryBean;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

/**
 * @Description
 * @ClassName mainTest06
 * @Author Evan
 * @date 2020.02.15 14:49
 */
public class mainTest06 {

    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig06.class);

    @Test
    public void test01() throws Exception {
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        Arrays.stream(beanDefinitionNames).forEach(System.out::println);


        ColorFactoryBean colorBean = applicationContext.getBean(ColorFactoryBean.class);
        //ColorFactoryBean 获得的是调用 gebBean () 产生的对象
        //默认获取到的是工厂bean调用getObject创建的对象
        System.out.println("bean的类型：" + colorBean.getClass());
        System.out.println(colorBean.getObject().toString());

        //要获取工厂Bean 本身，我们需要给id前面加一个&
        Object bean4 = applicationContext.getBean("&colorFactoryBean");
        System.out.println(bean4.getClass());
    }
}
