package com.evan.dao;

import lombok.ToString;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Service;


@Service
@ToString
public class MyBeanPostProcessor implements BeanPostProcessor {

    // 在初始化之前工作
    @Override
    public Object postProcessBeforeInitialization(Object bean, String s) throws BeansException {
        System.out.println("postProcessBeforeInitialization......" + bean.toString());
        return bean;
    }

    // 在初始化之后工作
    @Override
    public Object postProcessAfterInitialization(Object bean, String s) throws BeansException {
        System.out.println("postProcessAfterInitialization...." + bean.toString());
        return bean;
    }
}
