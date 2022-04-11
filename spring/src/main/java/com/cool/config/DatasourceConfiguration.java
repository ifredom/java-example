package com.cool.config;


import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

//  等同于   <context:property-placeholder location="classpath:jdbc.properties"/>
@PropertySource("classpath:jdbc.properties")
public class DatasourceConfiguration {

    @Value("${jdbc.driver}")
    private String driver;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;

//  等同于
//        <bean id="dataSource" class="com.mchange.v2.c3p0.ComboPooledDataSource">
//        <property name="driverClass" value="${jdbc.driver}"/>
//        <property name="jdbcUrl" value="${jdbc.url}"/>
//        <property name="user" value="${jdbc.username}"/>
//        <property name="password" value="${jdbc.password}"/>
//    </bean>

    // spring 会将被标记的方法的返回值，以指定名称注入到容器中
    // 借助@Value来设置可变值
    @Bean("dataSource")
    public DataSource getDataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();

        dataSource.setDriverClass(driver);
        dataSource.setJdbcUrl(url);
        dataSource.setUser(username);
        dataSource.setPassword(password);

        return dataSource;
    }
}
