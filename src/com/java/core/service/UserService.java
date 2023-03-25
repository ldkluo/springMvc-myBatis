package com.java.core.service;

import com.java.core.po.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/*
用户Service层接口
 */

public interface UserService {
    // 通过账号和密码查询用户
    public User findUser(String userconde,String password);
}
