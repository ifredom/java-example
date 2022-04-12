package com.commonmybatisplus;

import com.commonmybatisplus.dao.StudentDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CommonMybatisPlusApplicationTests {

    @Autowired
    private StudentDao studentDao;

    @Test
    void contextLoads() {
        System.out.println(studentDao.selectById(1));
        System.out.println(studentDao.selectList(null
        ));
    }

}
