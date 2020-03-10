package com.evan.service;

import com.evan.bean.Colors;
import org.springframework.beans.factory.FactoryBean;


// 创建一个spring定义的FactoryBean
public class ColorFactoryBean implements FactoryBean {

    /**
     * 返回一个 Color 对象，这个对象会添加到容器中
     *
     * @return
     * @throws Exception
     */
    @Override
    public Colors getObject() throws Exception {
        System.out.println("ColorFactoryBean 的 getObject()方法被调用");
        Colors color = new Colors();
        color.setRed(100);
        color.setGreen(100);
        color.setBlue(20);
        return color;
    }

    /**
     * 把传入的Class进行注册,Class既可以有@Configuration注解,也可以没有@Configuration注解
     * 怎么注册? 委托给了 org.springframework.context.annotation.AnnotatedBeanDefinitionReader.register 方法进行注册
     * 传入Class 生成  BeanDefinition , 然后通过 注册到 BeanDefinitionRegistry
     */
    @Override
    public Class<?> getObjectType() {
        return null;
    }

    /**
     * 是否单例
     * true : 这个bean 是单实例，在容器中保存一份
     * false ： 多实例 每次获取都会创建一个新的bean
     *
     * @return
     */
    @Override
    public boolean isSingleton() {
        return true;
    }
}
