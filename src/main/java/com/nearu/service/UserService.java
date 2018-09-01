package com.nearu.service;

import com.nearu.model.User;

import java.util.List;

/**
 * 用户service
 */
public class UserService {
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
        return null;
    }
    //复杂业务逻辑
}
