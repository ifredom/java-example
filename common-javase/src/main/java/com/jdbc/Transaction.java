package com.jdbc;


import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 事务
 */
public class Transaction {
    public static void main(String[] args) {

    }


    /**
     * 事务测试
     * 李四向吱吱转账
     */
    @Test
    public  void testTransaction(){
        Connection connection = null;
        String sql2 = "update firstdemo.teacher  set salary = salary-100 where name='lisi'";
        String sql = "update firstdemo.teacher  set salary = salary+100 where name='zhizhi'";

        PreparedStatement preparedStatement = null;

        try {
            connection = JDBCUtils.getConnection();
            connection.setAutoCommit(false); // 开启事务，避免提交

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate(); // 执行

//            int i = 1/0;  // 人为制造异常

            preparedStatement = connection.prepareStatement(sql2);
            preparedStatement.executeUpdate(); // 执行

            connection.commit();// 提交

        } catch (SQLException e) {
            System.out.println("异常");
            try{
                connection.rollback();
            }catch(SQLException throwables){
                throwables.printStackTrace();
            }
        } finally {
            JDBCUtils.dispose(null, preparedStatement, connection);
        }
    }
}
