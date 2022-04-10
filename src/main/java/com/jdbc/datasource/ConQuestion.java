package com.jdbc.datasource;

import com.jdbc.JDBCUtils;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import java.beans.PropertyVetoException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;


/**
 * 数据连接池
 * <p>
 * <p>
 * 下载导入 C3P0 jar包
 */
public class ConQuestion {
    public static void main(String[] args) {

        long currentTimeMillis = System.currentTimeMillis();
        for (int i = 0; i < 50; i++) {
            Connection connection = JDBCUtils.getConnection();

            JDBCUtils.dispose(null, null, connection);
        }
        long endTimeMillis = System.currentTimeMillis();
        System.out.println(endTimeMillis - currentTimeMillis);
    }

    @Test
    public void TestC3P0() throws IOException, PropertyVetoException, SQLException {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();

        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\mysql.properties"));

        String user = properties.getProperty("username");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");
        String driver = properties.getProperty("driver");

        comboPooledDataSource.setDriverClass(driver);
        comboPooledDataSource.setJdbcUrl(url);
        comboPooledDataSource.setUser(user);
        comboPooledDataSource.setPassword(password);


        // 设置初始化连接个数
        comboPooledDataSource.setInitialPoolSize(10);
        // 设置最大化连接个数
        comboPooledDataSource.setMaxPoolSize(50);

        // 此方法根据java中的顶级父类 DataSource 接口实现而来
        Connection connection = comboPooledDataSource.getConnection();


    }

    /**
     * 使用配置文件
     * 对配置文件位置有要求，位于src目录下
     *
     * @throws IOException
     * @throws PropertyVetoException
     * @throws SQLException
     */
    @Test
    public void TestC3P0ConfigFile() throws IOException, PropertyVetoException, SQLException {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource("c3p0_edu");

        long currentTimeMillis = System.currentTimeMillis();
        for (int i = 0; i < 500; i++) {
            Connection connection = comboPooledDataSource.getConnection();
            connection.close();
        }
        long endTimeMillis = System.currentTimeMillis();

        // 耗时 96 毫秒
        System.out.println("批量执行=" + (endTimeMillis - currentTimeMillis));

    }
}
