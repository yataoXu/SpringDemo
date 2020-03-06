package com.dynamicdatasource;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DynamicDataSource extends AbstractRoutingDataSource implements ApplicationContextAware {

    private ApplicationContext applicationContext ;




    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

    }

    /**
     * 连接数据源前,调用该方法
     */
    @Override
    protected Object determineCurrentLookupKey() {
        //1.获取手动设置的数据源参数DataSourceBean

        return null;
    }
}
