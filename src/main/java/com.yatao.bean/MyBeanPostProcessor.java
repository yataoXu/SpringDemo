package com.yatao.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Service
public class MyBeanPostProcessor implements BeanPostProcessor {

    /**
     * 在初始化之前工作
     *
     * @param bean
     * @param s
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String s) throws BeansException {
        System.out.println("postProcessBeforeInitialization......" + bean.toString());
        return bean;
    }

    /**
     * 在初始化之后工作
     *
     * @param bean
     * @param s
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String s) throws BeansException {
        System.out.println("postProcessAfterInitialization...." + bean.toString());
        return bean;
    }
}
