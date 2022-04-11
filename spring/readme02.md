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