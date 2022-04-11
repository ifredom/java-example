package com.cool.service;

import com.cool.dao.UserDao;


public class UserServiceImpl implements UserService {

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
        userDao.save();
    }
}
