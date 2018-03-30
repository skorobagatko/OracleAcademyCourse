package com.skorobahatko.lectures.lecture8.web.utils;

import java.io.IOException;
import java.util.Properties;

public class PropertyUtils {

    private static PropertyUtils instance;

    private boolean isInMemoryDB;
    private String jdbcUrl;
    private String dbUserLogin;
    private String dbUserPassword;
    private String dbDriver;

    private PropertyUtils() {
        loadProperties();
    }

    public static synchronized PropertyUtils getInstance() {
        if (instance == null) {
            instance = new PropertyUtils();
        }
        return instance;
    }

    private void loadProperties() {
        Properties prop = new Properties();
        try {
            prop.load(PropertyUtils.class.getClassLoader().getResourceAsStream("application.properties"));

            isInMemoryDB = Boolean.valueOf(prop.getProperty("isInMemoryDB"));
            dbDriver = prop.getProperty("dbDriver");
            jdbcUrl = prop.getProperty("jdbcUrl");
            dbUserLogin = prop.getProperty("dbUserLogin");
            dbUserPassword = prop.getProperty("dbUserPassword");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean isInMemoryDB() {
        return isInMemoryDB;
    }

    public void setInMemoryDB(boolean inMemoryDB) {
        isInMemoryDB = inMemoryDB;
    }

    public String getJdbcUrl() {
        return jdbcUrl;
    }

    public void setJdbcUrl(String jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
    }

    public String getDbUserLogin() {
        return dbUserLogin;
    }

    public void setDbUserLogin(String dbUserLogin) {
        this.dbUserLogin = dbUserLogin;
    }

    public String getDbUserPassword() {
        return dbUserPassword;
    }

    public void setDbUserPassword(String dbUserPassword) {
        this.dbUserPassword = dbUserPassword;
    }

    public String getDbDriver() {
        return dbDriver;
    }

    public void setDbDriver(String dbDriver) {
        this.dbDriver = dbDriver;
    }
}
