package com.cool.dao.impl;

import com.cool.dao.UserDao;
import com.cool.domain.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Properties;

// <bean id="userDao" class="com.cool.dao.impl.UserDaoImpl">

//@Component("userDao")
@Repository("userDao")
public class UserDaoImpl implements UserDao {

    private List<String> stringList;
    private Map<String, User> userMap;
    private Properties properties;

    public void setStringList(List<String> stringList) {
        this.stringList = stringList;
    }

    public void setUserMap(Map<String, User> userMap) {
        this.userMap = userMap;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public String save() {
//        System.out.println("stringList: " + stringList);
//        System.out.println("userMap: " + userMap);
//        System.out.println("properties: " + properties);
        System.out.println("保存用户");
        return "保存用户";
    }

    public void init() {
        System.out.println("init userDaoImpl");
    }

    public void destroy() {
        System.out.println("destroy userDaoImpl");
    }
}
