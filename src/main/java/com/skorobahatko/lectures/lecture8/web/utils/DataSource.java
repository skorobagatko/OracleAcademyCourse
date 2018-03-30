package com.skorobahatko.lectures.lecture8.web.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DataSource {

    private static ComboPooledDataSource connectionPool;
    private static DataSource dataSource;

    private DataSource() {
        initConnectionPool();
    }

    public static synchronized DataSource getInstance() {
        if (dataSource == null) {
            dataSource = new DataSource();
        }
        return dataSource;
    }

    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = connectionPool.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void initConnectionPool() {
        connectionPool = new ComboPooledDataSource();
        PropertyUtils prop = PropertyUtils.getInstance();
        try {
            connectionPool.setDriverClass(prop.getDbDriver());
            connectionPool.setJdbcUrl(prop.getJdbcUrl());
            connectionPool.setUser(prop.getDbUserLogin());
            connectionPool.setPassword(prop.getDbUserPassword());

            connectionPool.setMinPoolSize(5);
            connectionPool.setAcquireIncrement(10);
            connectionPool.setMaxPoolSize(200);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}