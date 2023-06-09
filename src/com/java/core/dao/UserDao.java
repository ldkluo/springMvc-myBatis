package com.java.core.dao;

import com.java.core.po.User;
import org.apache.ibatis.annotations.Param;

/*
用户
 */
public interface UserDao {
    /*
    通过账号和密码查询用户
     */
    public User findUser(@Param("usercode")String usercode,
                         @Param("password")String password);
}
