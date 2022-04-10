package com.jdbc.batch;


import com.jdbc.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 批处理SQL
 * 减少网络开销和编译次数，所以效率高
 */
public class BatchTest {

    @Test
    public void noBatch() throws SQLException {
        Connection connection = JDBCUtils.getConnection();

        String sql = "insert into transaction1 values(?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        long currentTimeMillis = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            preparedStatement.setString(1, "jack" + i);
            preparedStatement.setInt(2, 100 + i);
            preparedStatement.executeUpdate();
        }
        long endTimeMillis = System.currentTimeMillis();

        // 耗时 7638 毫秒
        System.out.println(endTimeMillis - currentTimeMillis);

        JDBCUtils.dispose(null, preparedStatement, connection);
    }

    /**
     * 使用批量执行
     * 一定要在连接数据库是添加参数 支持批量执行
     *
     * ?rewriteBatchedStatements=true
     * @throws SQLException
     */
    @Test
    public void useBatch() throws SQLException {
        Connection connection = JDBCUtils.getConnection();

        String sql = "insert into transaction1 values(?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        long currentTimeMillis = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            preparedStatement.setString(1, "jack" + i);
            preparedStatement.setInt(2, 100 + i);
            // 将sql语句添加如批量包
            preparedStatement.addBatch();
            // 1000
            if ((i + 1) % 1000 == 0) {
                preparedStatement.executeBatch();
            }
        }
        long endTimeMillis = System.currentTimeMillis();

        // 耗时 96 毫秒
        System.out.println("批量执行=" + (endTimeMillis - currentTimeMillis));

        JDBCUtils.dispose(null, preparedStatement, connection);
    }
}
