package com.nearu.service;

import com.nearu.model.User;
import com.nearu.util.DBUtil;
import com.nearu.util.PropsUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * 用户service
 */
public class UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    //增
    /**
     * 创建用户
     * @param user
     * @return
     */
    public boolean createUser(User user){
        return false;
    }

    //删

    /**
     * 注销用户
     * @return
     */
    public boolean writeOffUser(){
        return false;
    }

    //改

    /**
     * 更新用户信息
     * @return
     */
    public boolean updateUserInfo(){
        return false;
    }

    //查

    public User getUserById(long id){
        return null;
    }

    public List<User> getUsersByKeys(User user){
        if(user == null){
            return getAllUsers();
        }
        return null;
    }

    public List<User> getAllUsers(){
        List<User> userList = new ArrayList<User>();
        String sql = "SELECT * FROM t_user";
        userList = DBUtil.queryEntityList(User.class, sql, null);
        return userList;
    }
    //复杂业务逻辑
}
