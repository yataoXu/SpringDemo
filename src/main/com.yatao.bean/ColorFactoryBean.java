package com.yatao.bean;

import org.springframework.beans.factory.FactoryBean;


// 创建一个sprig定义的FactoryBean
public class ColorFactoryBean implements FactoryBean {

    /**
     *
     * 返回一个 Color 对象，这个对象会添加到容器中
     *
     * @return
     * @throws Exception
     */
    @Override
    public Color getObject() throws Exception {
        return new Color();
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    /**
     *
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
