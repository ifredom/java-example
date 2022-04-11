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

1. @Component 属性value 指定bean的Id
2. @Controller  用于表现层（与@Componnet 功能一样）
3. @Service 用于业务层（与@Componnet 功能一样）
4. @Repository 用于持久层（与@Componnet 功能一样）

---

5. @Autowried 作用：自动按类型注入
6. @Qualifier:作用：再按照类中注入的基础之上再按照名称注入，它在给类成员注入时不能单独使用和Autowired配合使用，但是给方法注入时可以
7. @Resources
   作用：直接按照bean的id注入，它可以独立使用
   属性：name:用于指定bean的id
   以上三种注入只能注入其他bean类型的数据，而基本类型和String类型无法使用上述注解实现
8. @Value
   作用：用于注入基本类型和String类型数据
   属性：value：用于指定数据的值，它可以使用spring中的spEL(也就是spring的el表达式)
   SpEl的写法：${表达式}

## AOP 在 Spring 中的作用

3种使用注解方式