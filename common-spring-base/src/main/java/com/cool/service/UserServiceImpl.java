package com.cool.service;

import com.cool.dao.UserDao;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

//<bean id="userService" class="com.cool.service.UserServiceImpl">

//@Component("userService")
@Service("userService")
public class UserServiceImpl implements UserService {

    // 注入普通属性 ${} 可以去配置文件中查找键值对
    @Value("doom cool ${jdbc.driver}")
    private String driver;

    //<constructor-arg name="userDao" ref="userDao" />
//    @Autowired // 按照数据类型匹配查找
//    @Qualifier("userDao") // 按照ID名称匹配查找
    @Resource(name = "userDao")
    private UserDao userDao;

    // 构造注入
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    // set 注入
//    public void setUserDao(UserDao userDao) {
//        this.userDao = userDao;
//    }

    @Override
    public void save() {
        System.out.println(driver);
        userDao.save();
    }

    @PostConstruct
    public void init() {
        System.out.println(" init 生命周期 注解测试");
    }

    @PreDestroy
    public void destroy() {
        System.out.println(" destroy 生命周期 注解测试");
    }
}
