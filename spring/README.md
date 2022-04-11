# 工程简介

```java
package com.ifcool;

import com.ifcool.dao.UserDao;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserDaoDemo {
    public static void main(String[] args) {
        // ApplicationContext
        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao1 = app.getBean("userDao", UserDao.class);
        UserDao userDao2 = app.getBean("userDao", UserDao.class);
        userDao1.save();
        System.out.println(userDao1==userDao2);
        
        app.close();
    }
}

```

## Bean

> 将 Spring容器中的 Dao 注入到 Service中，并将 Service 注册为 bean.通过调用bean 来使用

```xml
<!-- scope 作用域-->
<!--生命周期-->
<bean id="userDao" class="com.ifcool.dao.impl.UserDaoImpl" scope="singleton" init-method="init" destroy-method="destroy"></bean>

<!-- 构造创建 -->
<bean id="userDao" class="com.ifcool.dao.impl.UserDaoImpl" factory-method="com.ifcool.factory.StaticFactory"></bean>

<!-- 实例创建 -->
<bean id="factory" class="com.ifcool.factory.DynamicFactory"></bean>
<bean id="userDao" factory-bean="factory" factory-method="getUserDao"></bean>
```
scope:
- singleton(默认), 初始化容器时创建，仅仅一个，创建则一直存在，直到容器销毁
- prototype ， 创建多个，调用 getBean 时创建，长时间不使用，垃圾回收器销毁

--- 

生命周期:
- init-method
- destroy-method

---

创建方式：
- 构造函数
- 实例方法


