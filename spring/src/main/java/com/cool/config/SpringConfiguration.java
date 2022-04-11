package com.cool.config;


import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

// 标志该类是Spring核心配置类
@Configuration
//<context:component-scan base-package="com.cool"/>
@ComponentScan("com.cool")
// <import resource="" />
@Import(DatasourceConfiguration.class)
public class SpringConfiguration {


}
