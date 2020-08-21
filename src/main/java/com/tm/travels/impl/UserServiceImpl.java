package com.tm.travels.impl;

import com.tm.travels.dao.UserMapper;
import com.tm.travels.entity.User;
import com.tm.travels.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description:
 * @Author tangmin
 * @Date 2020/8/21 11:55
 **/
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void register(User user) {
        if (userMapper.queryByUserName(user.getUsername())==null) {
            userMapper.insert(user);
        }else {
            throw new RuntimeException("用户名已存在");
        }
    }

    @Override
    public User login(User user) {
        User userDB = userMapper.queryByUserName(user.getUsername());
        if (userDB!=null) {
            if (user.getPassword().equals(userDB.getPassword())) {
                return userDB;
            }
            throw new RuntimeException("密码错误");
        }else {
            throw new RuntimeException("用户名错误");
        }
    }
}

