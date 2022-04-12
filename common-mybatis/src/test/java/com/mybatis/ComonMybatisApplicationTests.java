package com.mybatis;

import com.mybatis.dao.BookDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ComonMybatisApplicationTests {

    @Autowired
    private BookDao bookDao;


    @Test
    void contextLoads() {
        System.out.println(bookDao.getByName("tom"));
    }

}
