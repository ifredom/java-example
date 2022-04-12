package com.cool.test;


import com.cool.Application;
import com.cool.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.SQLException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
@SpringBootTest(classes = Application.class)
public class SpringHunitTest {

    @Resource // 按照数据类型匹配查找
    private UserService userService;

    @Autowired
    private DataSource dataSource;

    @Test
    public void testUserService() throws SQLException {
        userService.save();

        System.out.println(dataSource.getConnection());
    }
}
