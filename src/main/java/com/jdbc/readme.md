# jdbc

1. jdbc为访问不同的数据库提供了同意的接口
2. java 厂商定义 数据库访问 jdbc 接口规范


JDBC编写步骤

1. 注册驱动 - 加载 Driver类
2. 获取连接 - 得到 Connection
3. 执行增删改查 -发送 SQL 给 mysql 执行
4. 释放资源- 关闭相关连接

## 连接数据库的几种方式

1. 使用数据库驱动 Driver 连接
2. 使用反射
3. 使用DriverMange统一管理
4. 使用DriverMange统一管理，免注册
5. properties管理数据 + DriverManager连接 （最佳方式）