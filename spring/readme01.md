# 01-依赖注入


依赖注入: 书写业务时使用的是 userService,而 userService 和 userDao 都在容器中，那么可以简化为将 userDao 添加到 userService 中。
操作方法: 就是使用set进行动态绑定

```java
package com.cool.service;
import com.cool.dao.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class UserServiceImpl implements UserService {
    private UserDao userDao;
    // 核心 set方法，bean中自动使用的时set后的 UserDao 并将首字母小写
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
    @Override
    public void save() {
        userDao.save();
    }
}
```

```xml
    <bean id="userDao" class="com.cool.dao.impl.UserDaoImpl"></bean>
    <bean id="userService" class="com.cool.service.UserServiceImpl">
        <property name="userDao" ref="userDao"></property>
    </bean>
```


## 命名空间

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:p="http://www.springframework.org/schema/p"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="userDao" class="com.cool.dao.impl.UserDaoImpl"></bean>
<!--    使用p:userDao-ref="userDao" 注入对象 ， 使用p:userDao="userDao" 注入普通属性-->
    <bean id="userService" class="com.cool.service.UserServiceImpl" p:userDao-ref="userDao" />
</beans>
```

## 构造注入
```java
package com.cool.service;

import com.cool.dao.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServiceImpl implements UserService {
    private UserDao userDao;
    // 构造注入
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }
    @Override
    public void save() {
        userDao.save();
    }
}
```

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="userDao" class="com.cool.dao.impl.UserDaoImpl"></bean>
    <bean id="userService" class="com.cool.service.UserServiceImpl">
        <constructor-arg name="userDao" ref="userDao" />
    </bean>
</beans>
```