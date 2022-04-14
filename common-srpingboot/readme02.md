# 松散绑定

- @ConfigurationProperties(prefix="datasource)  松散绑定，标准使用 全小写

## 测试类 不执行向数据库写入数据

- @Transactional  ：默认含有@Rollback(true) 自动回滚

## [内存数据库H2](https://www.bilibili.com/video/BV15b4y1a7yG?p=91)


## 集成redis

1. windows搜索下载redis免安装包，并启动 `redis> redis-server.exe redis.windows.conf`
2. 设置坐标
3. 添加配置
4. 使用测试类测试
```yml
spring:
  application:
    name: comon-mybatis
  datasource:
    druid:
      driver-class-name: com.mysql.cj.jdbc.Driver
      url: jdbc:mysql://localhost:3306/firstdemo?serverTimezone=UTC
      username: root
      password: 123456
// 设置类型，以及redis相关配置
  cache:
    type: redis
  redis:
    host: localhost
    port: 6379

```

如果要操作DaoEntity的类型数据,需要自定义实现 redisTemplate

```java
package com.springboot.cache;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
public class RedisTest {
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void getName(){
        redisTemplate.opsForValue().set("name","redis set name");
        System.out.println(redisTemplate.opsForValue().get("name"));
    }
}

```

> 如何查看redis中缓存了哪些数据？**redis启动后， 安装目录下执行 ``redis-cli.exe`**

- keys * 查看所有数据
- flushdb 清空所有数据

每次手动启动redis比较麻烦，将其注册未 windows 服务

```bash
# 注册服务
> redis-server --service-install redis.windows.conf --loglevel verbose


redis-server --service-uninstall // 卸载服务
redis-server --service-start // 启动Redis
redis-server --service-stop // 停止Redis
```

---

redis 还支持使用注解的方式来进行使用，需要另外配置，搜索资料

---

SpringBoot对Jedis的支持:
在1.×版本的时候，SpringBoot的底层还是使用Jedis来连接Redis的，
但是在2.×版本后，就换成了Lettuce。两者的区别如下：
Jedis:  采用的直连，多个线程操作的话，是不安全的，如果想要避免不安全的，使用 jedis pool 连接池！ 更像 BIO 模式！
Lettuce:  采用netty，实例可以再多个线程中进行共享，不存在线程不安全的情况！可以减少线程数据了，更像 NIO 模式！
