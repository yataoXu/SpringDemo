package com.evan.bean;


import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class Cat implements InitializingBean, DisposableBean {

    public Cat() {
        System.out.println("cat constructor ....");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("cat destroy ....");
    }

    /**
     * 对象创建完成，并赋值好，调用初始化方法
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("cat init ....");
    }
}
