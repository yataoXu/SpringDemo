package com.evan.tx.service;

/**
 * @Description
 * @ClassName ServiceA
 * @Author Evan
 * @date 2020.07.19 17:25
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ServiceA {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private ServiceB serviceB;

    @Transactional
    public Response insert() {
        executeSql("insert into t select 'serviceA 开始'");

        try {
            serviceB.insert();
        } catch (Exception e) {
            System.out.println("serviceB#insert挂了，原因： " + e);
            return Response.FAIL;
        }
        return Response.SUCC;
    }

    private void executeSql(String sql) {
        Connection connection = DataSourceUtils.getConnection(dataSource);
        try {
            connection.createStatement().execute(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}