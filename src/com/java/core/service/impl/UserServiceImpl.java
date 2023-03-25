package com.java.core.service.impl;

import com.java.core.dao.UserDao;
import com.java.core.po.User;
import com.java.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/*
用户Service接口实现类
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
    //注入UserDao
    @Autowired
    private UserDao userDao;
    // 通过账号和密码查询用户
    @Override
    public User findUser(String userconde, String password) {
        User user = userDao.findUser(userconde, password);
        return user;
    }
}
