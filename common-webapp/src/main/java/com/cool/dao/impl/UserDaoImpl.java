package com.cool.dao.impl;

import com.cool.dao.UserDao;
// <bean id="userDao" class="com.cool.dao.impl.UserDaoImpl">

public class UserDaoImpl implements UserDao {

    private  String username;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private int age;


    public String save() {
        System.out.println("保存用户");
        return "保存用户";
    }
}
