package com.cool.dao.impl;

import com.cool.dao.UserDao;

public class UserDaoImpl implements UserDao {

    public String save() {
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
