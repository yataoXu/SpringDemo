package com.evan.tx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Description
 * @ClassName ServiceB
 * @Author Evan
 * @date 2020.07.19 17:26
 */
@Service
public class ServiceB {
    @Autowired
    private DataSource dataSource;

    // 用于控制是否模拟insert方法挂了的情况。
    private boolean flag = true;

    @Transactional
    public void insert() {
        executeSql("insert into t select '这里是ServiceB挂之前'");

        if (true) {
            throw new RuntimeException("模拟内层事务某条语句挂了的情况");
        }

        executeSql("insert into t select '这里是ServiceB挂之后'");
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