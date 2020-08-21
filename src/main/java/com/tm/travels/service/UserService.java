package com.tm.travels.service;

import com.tm.travels.entity.User;

/**
 * @Description:
 * @Author tangmin
 * @Date 2020/8/21 11:54
 **/
public interface UserService {
    // 注册
    void register(User user);
    // 登录
    User login(User user);
}
