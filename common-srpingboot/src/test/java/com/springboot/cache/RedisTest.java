package com.springboot.cache;

import com.springboot.common.utils.RedisUtils;
import com.springboot.domain.dao.StudentDao;
import com.springboot.domain.entity.StudentEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
public class RedisTest {

    @Autowired
    private RedisUtils redisUtils;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StudentDao studentDao;


    // 测试redis, 原始写法
    @Test
    public void getNameString() {
        redisTemplate.opsForValue().set("name", "redis set name");
        System.out.println(redisTemplate.opsForValue().get("name"));
    }

    // 测试redis, 封装工具后
    @Test
    public void saveObject() {
        StudentEntity student = studentDao.selectById(1);
        System.out.println(student);

        redisUtils.set("1", student);

        System.out.println(redisUtils.get("1"));
    }
}
