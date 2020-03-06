package com.dynamicdatasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class MultiDataSource extends AbstractRoutingDataSource {

    /* ThreadLocal,叫线程本地变量或线程本地存储。
     * ThreadLocal为变量在每个线程中都创建了一个副本，那么每个线程可以访问自己内部的副本变量。
     * 这里使用它的子类InheritableThreadLocal用来保证父子线程都能拿到值。
     */
    private static final ThreadLocal<String> dataSourceKey = new InheritableThreadLocal<>();


    /**
     *  返回当前dataSourceKey的值
     */
    public static void toDefault() {
        dataSourceKey.remove();
    }

    /**
     * 设置dataSourceKey的值
     * @param dataSource
     */
    public static void setDataSourceKey(String dataSource) {
        dataSourceKey.set(dataSource);
    }


    /**
     * 返回当前dataSourceKey的值
     * @return
     */
    @Override
    protected Object determineCurrentLookupKey() {
        return dataSourceKey.get();
    }
}
