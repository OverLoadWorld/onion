package com.nearu.util;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

/**
 * Title
 *
 * @Description:
 * @Author: Zhao Zhenhua [zhaozhenhua1@xiaomi.com]
 * @Since: 9/10/18 3:00 PM
 */
public class DBUtil {

    private static final ThreadLocal<Connection> CONNECTION_THREAD_LOCAL;

    private static final Logger LOGGER = LoggerFactory.getLogger(DBUtil.class);
    private static final String DRIVER;
    private static final String URL;
    private static final String USERNAME;
    private static final String PASSWORD;

    private static final QueryRunner QUERY_RUNNER;

    private static final BasicDataSource BASIC_DATA_SOURCE;

    static {
        CONNECTION_THREAD_LOCAL = new ThreadLocal<Connection>();
        QUERY_RUNNER = new QueryRunner();

        Properties conf = PropsUtil.loadProps("db.properties");
        DRIVER = conf.getProperty("jdbc.driver");
        URL = conf.getProperty("jdbc.url");
        USERNAME = conf.getProperty("jdbc.username");
        PASSWORD = conf.getProperty("jdbc.password");

        BASIC_DATA_SOURCE = new BasicDataSource();
        BASIC_DATA_SOURCE.setDriverClassName(DRIVER);
        BASIC_DATA_SOURCE.setUrl(URL);
        BASIC_DATA_SOURCE.setUsername(USERNAME);
        BASIC_DATA_SOURCE.setPassword(PASSWORD);
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            LOGGER.error("Can not load jdbc driver", e);
        }
    }

    public static Connection getConnection(){
        Connection conn = CONNECTION_THREAD_LOCAL.get();
        if(conn == null){
            try {
                conn = BASIC_DATA_SOURCE.getConnection();
            } catch (SQLException e) {
                e.printStackTrace();
                LOGGER.error("get Connection failed", e);
                throw new RuntimeException();
            } finally {
                CONNECTION_THREAD_LOCAL.set(conn);
            }
        }
        return conn;
    }

    public static <T> List<T> queryEntityList(Class<T> entityClass, String sql, Object... params){
        List<T> entityList = null;
        try {
            Connection connection = getConnection();
            entityList = QUERY_RUNNER.query(connection, sql, new BeanListHandler<T>(entityClass), params);
        } catch (SQLException e) {
            e.printStackTrace();
            LOGGER.error("query Entity List failed", e);
            throw new RuntimeException();
        }
        return entityList;
    }

    public static <T> T queryEntity(Class<T> entityClass, String sql, Object... params){
        T entity = null;
        try {
            Connection connection = getConnection();
            entity = QUERY_RUNNER.query(connection, sql, new BeanHandler<T>(entityClass), params);
        } catch (SQLException e) {
            e.printStackTrace();
            LOGGER.error("query Entity failed", e);
            throw new RuntimeException();
        }
        return entity;
    }
}
