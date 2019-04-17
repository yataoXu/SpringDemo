package com.yatao.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @ Author : Evan.
 * @ Description :
 * @ Date : Crreate in 2019/4/17 10:50
 * @Mail : xuyt@zendaimoney.com
 */

@Component
public class MyBeanPostProcessor implements BeanPostProcessor {

    /**
     * 在初始化之前工作
     *
     * @param o
     * @param s
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String s) throws BeansException {
        System.out.println("postProcessBeforeInitialization......");
        return bean;
    }

    /**
     * 在初始化之后工作
     *
     * @param o
     * @param s
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String s) throws BeansException {
        System.out.println("postProcessAfterInitialization....");
        return bean;
    }
}
