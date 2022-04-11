package com.cool.dao.impl;

import com.cool.dao.UserDao;
import org.springframework.stereotype.Repository;

// <bean id="userDao" class="com.cool.dao.impl.UserDaoImpl">
//@Component("userDao")
@Repository("userDao")
public class UserDaoImpl implements UserDao {

    public String save() {
        System.out.println("保存用户");
        return "保存用户";
    }
}
