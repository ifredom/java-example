package com.cool.web;

import com.cool.config.SpringConfiguration;
import com.cool.dao.UserDao;
import com.cool.service.UserService;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class UserDaoDemo {

    public static void main(String[] args) {
        ApplicationContext app =new AnnotationConfigApplicationContext(SpringConfiguration.class);
        UserService userService = app.getBean(UserService.class);
        userService.save();
        System.out.println("完成");
    }

    // 测试依赖注入 1
    @Test
    public void testService() {
        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = app.getBean(UserService.class);
        userService.save();
        System.out.println("完成");
    }

    // 测试依赖注入 1
    @Test
    public void testServiceDependencyInjection() {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = app.getBean("userDao", UserDao.class);
        userDao.save();

        // 这两句测试空指针异常
        // 因为直接new出来的 userServie 内部找 userDao 对象时，没有使用到set方法，所以没有userDao对象
//        UserService userService = new UserServiceImpl();
//        userService.save();
    }

    @Test
    public void testService2() {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao1 = app.getBean("userDao", UserDao.class);
        UserDao userDao2 = app.getBean("userDao", UserDao.class);
        userDao1.save();
        System.out.println(userDao1 == userDao2);
    }

    @Test
    public void testService3() {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        ComboPooledDataSource dataSource = app.getBean("dataSource", ComboPooledDataSource.class);
        System.out.println(dataSource.getDriverClass());
        System.out.println(dataSource.getJdbcUrl());
        System.out.println(dataSource.getUser());
        System.out.println(dataSource.getPassword());
    }
}
