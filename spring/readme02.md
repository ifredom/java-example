# Spring相关API

- CLassPathXmlApplicationContext 从项目resource中读取
- FileSystemXmlApplicationContext 从磁盘任意位置读取
- AnnotationConfigApplicationContext

## getBean

- getBean("id"); // 存在多个相同Bean使用
- getBean(Class); // 存在一个Bean可以使用

## Spring数据源配置(数据库连接池)

> c3p0, druid(德鲁伊)

1. 导入数据源坐标和数据库驱动坐标
2. 创建数据源对象
3. 设置数额源连接个数等基本配置
4. 释放数据源

## Spring注解开发

常见注解

1. @Component 在类上使用，实例化Bean
2. @Controller 用于web表现层（与@Componnet 功能一样）
3. @Service 用于service业务层（与@Componnet 功能一样）
4. @Repository 用于dao持久层（与@Componnet 功能一样）

---

5. @Autowried 作用：自动按类型注入
6. @Qualifier:作用：再按照类中注入的基础之上再按照名称注入，它在给类成员注入时不能单独使用和Autowired配合使用，但是给方法注入时可以
7. @Resources 作用：直接按照bean的id注入，它可以独立使用 属性：name:用于指定bean的id 以上三种注入只能注入其他bean类型的数据，而基本类型和String类型无法使用上述注解实现
8. @Value 作用：用于注入基本类型和String类型数据 属性：value：用于指定数据的值，它可以使用spring中的spEL(也就是spring的el表达式)
   SpEl的写法：${表达式}

---

9. @PostConstruct 初始化生命周期
10. @PreDestroy 销毁生命周期

## Spring注解使用

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
    <!--   配置组件扫描 -->
    <context:component-scan base-package="com.cool"/>
</beans>
```

```java
import javax.annotation.Resource;

//等同于 <bean id="userService" class="com.cool.service.UserServiceImpl">
@Component("userDao")
public class UserDaoImpl implements UserDao {
}

@Service("userService")
public class UserServiceImpl implements UserService {

    // 注入普通属性 ${} 可以去配置文件中查找键值对
    @Value("doom cool ${jdbc.driver}")
    private String driver;

    // 等同于<constructor-arg name="userDao" ref="userDao" />
//   @Autowired
//   @Qualifier("userDao")
    @Resource(name = "userDao") // 再次等同于 @Autowired + @Qualifier("userDao")
    private UserDao userDao;

    @PostConstruct
    public void init() {
        System.out.println(" init 生命周期 注解测试");
    }

    @PreDestroy
    public void destroy() {
        System.out.println(" destroy 生命周期 注解测试");
    }
}
```

使用注解，set方法可以省略不写


## Spring注解使用-- 新注解


老注解的局限性：
- 非自定义Bean 
- component-scan

新注解 使用  new AnnotationConfigApplicationContext(SpringXXConfig.class)
- @Configuration
- @ComponentScan
- @Bean


```java
package com.cool.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// 标志该类是Spring核心配置类

//<context:component-scan base-package="com.cool"/>
@Configuration
@ComponentScan("com.cool")
public class SpringConfiguration {
}

```
## AOP 在 Spring 中的作用

3种使用注解方式



## Spring 集成 Junit

https://www.bilibili.com/video/BV1WZ4y1P7Bp?p=37

未成功，先跳过