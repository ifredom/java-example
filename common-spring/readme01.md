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


## 注入普通属性

使用set方法注入普通属性 username 和age
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="userDao" class="com.cool.dao.impl.UserDaoImpl">
        <property name="username" value="zhangsan"/>
        <property name="age" value="18"/>
    </bean>
</beans>
```
```java
package com.cool.dao.impl;

import com.cool.dao.UserDao;

public class UserDaoImpl implements UserDao {

    private String username;
    private int age;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String save() {
        System.out.println("额外做一些事情......"+username+age);
        System.out.println("保存用户");
        return "保存用户";
    }
}

```

## 注入List,Map， 集合

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

<!--    <bean id="userDao" class="com.cool.dao.impl.UserDaoImpl">-->
<!--        <property name="username" value="zhangsan"/>-->
<!--        <property name="age" value="18"/>-->
<!--    </bean>-->


    <bean id="userDao" class="com.cool.dao.impl.UserDaoImpl">
        <property name="stringList">
            <list>
                <value>aaa</value>
                <value>bbb</value>
                <value>ccc</value>
            </list>
        </property>
        <property name="userMap">
            <map>
                <entry key="user1" value-ref="user1"></entry>
                <entry key="user2" value-ref="user2"></entry>
            </map>
        </property>

        <property name="properties">
            <props>
                <prop key="p1">ppp1</prop>
                <prop key="p2">ppp2</prop>
                <prop key="p3">ppp3</prop>
            </props>
        </property>
    </bean>
    <bean id="user1" class="com.cool.domain.User">
        <property name="name" value="lucy"></property>
        <property name="addr" value="tianjin"></property>
    </bean>
    <bean id="user2" class="com.cool.domain.User">
        <property name="name" value="lucy"></property>
        <property name="addr" value="tianjin"></property>
    </bean>

    <bean id="userService" class="com.cool.service.UserServiceImpl">
        <constructor-arg name="userDao" ref="userDao" />
    </bean>
</beans>
```

```java
package com.cool.domain;

public class User {
    private String name;
    private String addr;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", addr='" + addr + '\'' +
                '}';
    }
}

```