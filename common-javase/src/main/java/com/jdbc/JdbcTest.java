package com.jdbc;

import com.mysql.cj.jdbc.Driver;
import javafx.application.Application;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * jdbc 驱动连接数据库
 * <p>
 * 前置工作，前往mysql官网下载 mysql驱动，
 * <p>
 * 鼠标右键-添加库，确定
 * 方式5 为常用
 */
public class JdbcTest {

    public static void main(String[] args) throws SQLException {

        // 1.注册驱动
        Driver driver = new Driver();
        // 2,获取链接
        String url = "jdbc:mysql://localhost:3306/firstdemo";

        Properties properties = new Properties();
        properties.setProperty("username", "root");
        properties.setProperty("password", "123456");

        Connection connect = driver.connect(url, properties);

        // 3. 执行增删改查 -发送 SQL 给 mysql 执行
//        String sql = "insert into student values('jdbc','java',30,1234,9,'boss',4)";
        String sql = "update student set name='周星驰' where id =9";
        Statement statement = connect.createStatement();

        int rows = statement.executeUpdate(sql);

        String addResult = rows > 0 ? "成功" : "失败";

        System.out.println(addResult);

        // 4. 释放资源- 关闭相关连接
        statement.close();
        connect.close();
    }

    // 反射
    @Test
    public void connect02() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, SQLException {

        Driver driver = Driver.class.getDeclaredConstructor().newInstance();
        String url = "jdbc:mysql://localhost:3306/firstdemo";

        Properties properties = new Properties();
        properties.setProperty("username", "root");
        properties.setProperty("password", "123456");

        Connection connect = driver.connect(url, properties);


        String sql = "update student set name='周润发' where id =9";
        Statement statement = connect.createStatement();
        int rows = statement.executeUpdate(sql);
        String addResult = rows > 0 ? "成功" : "失败";

        System.out.println(addResult);

        // 4. 释放资源- 关闭相关连接
        statement.close();
        connect.close();
    }

    // 3,使用DriverMange统一管理
    @Test
    public void connect03() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, SQLException {
        Driver driver = Driver.class.getDeclaredConstructor().newInstance();
        String url = "jdbc:mysql://localhost:3306/firstdemo";
        String user = "root";
        String password = "123456";

        DriverManager.registerDriver(driver);

        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection);
    }

    /**
     * 4,使用DriverMange统一管理，免注册 （最新的方式，常用连接方式）
     *
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws SQLException              查看Driver源码，静态代码块，在class创建时执行，所以驱动被自动注册了
     *                                   <p>
     *                                   public class Driver extends NonRegisteringDriver implements java.sql.Driver {
     *                                   public Driver() throws SQLException {
     *                                   }
     *                                   <p>
     *                                   static {
     *                                   try {
     *                                   DriverManager.registerDriver(new Driver());
     *                                   } catch (SQLException var1) {
     *                                   throw new RuntimeException("Can't register driver!");
     *                                   }
     *                                   }
     *                                   }
     */
    @Test
    public void connect04() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, SQLException {
        Driver driver = Driver.class.getDeclaredConstructor().newInstance();
        String url = "jdbc:mysql://localhost:3306/firstdemo";
        String user = "root";
        String password = "123456";

        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection);
    }


    /**
     * 最佳连接方式
     * @throws IOException
     * @throws SQLException
     */
    @Test
    public void connect05() throws IOException, SQLException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\mysql.properties"));

        String user = properties.getProperty("username");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");


        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection);
        connection.close();
    }
}
