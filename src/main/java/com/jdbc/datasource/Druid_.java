package com.jdbc.datasource;


import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * 德鲁伊连接池
 *
 *
 */
public class Druid_ {
    public static void main(String[] args) throws Exception {

        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\mysql.properties"));


        // 创建一个连接池
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);

        long currentTimeMillis = System.currentTimeMillis();
        for (int i = 0; i < 50; i++) {
            Connection connection = dataSource.getConnection();
            connection.close();
        }
        long endTimeMillis = System.currentTimeMillis();

        // 耗时 96 毫秒
        System.out.println("批量执行=" + (endTimeMillis - currentTimeMillis));
    }
}
