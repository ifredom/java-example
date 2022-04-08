package com.jdbc;

import com.mysql.cj.jdbc.Driver;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.Properties;

public class StatementTest {
    public static void main(String[] args) {

    }

    @Test
    public void testStatement() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, SQLException {
        Driver driver = Driver.class.getDeclaredConstructor().newInstance();
        String url = "jdbc:mysql://localhost:3306/firstdemo";

        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "123456");

        Connection connect = driver.connect(url, properties);


        String sql = "select * from student where name =?";
        PreparedStatement statement = connect.prepareStatement(sql);
        statement.setString(1, "tom");
        //使用PreparedStatement，执行查询时executeQuery()不能加入sql参数
        ResultSet resultSet = statement.executeQuery();

        String addResult = resultSet.next() ? "成功" : "失败";

        System.out.println(addResult);

        // 4. 释放资源- 关闭相关连接
        resultSet.close();
        statement.close();
        connect.close();
    }

    /**
     * 使用工具类
     */
    @Test
    public void testUseJDBCUtils() {
        Connection connection = null;

        String sql = "update firstdemo.student set name=? where classes =?";

        PreparedStatement preparedStatement = null;
        try {
            connection = JDBCUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, "刘德华");
            preparedStatement.setInt(2, 4);
            int i = preparedStatement.executeUpdate();

            String result = i > 0 ? "成功" : "失败";

            System.out.println(result);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.dispose(null, preparedStatement, connection);
        }
    }

    /**
     * 使用工具类
     */
    @Test
    public void test2UseJDBCUtils() {
        Connection connection = null;

        String sql = "select * from firstdemo.student";

        PreparedStatement preparedStatement = null;

        ResultSet resultSet = null;
        try {
            connection = JDBCUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);

            // 结果集
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String work = resultSet.getString("work");
                int age = resultSet.getInt("age");
                String department = resultSet.getString("department");
                System.out.println(name + " == " + work + " == " + age + " == " + department +"\r\n");
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.dispose(resultSet, preparedStatement, connection);
        }
    }
}
