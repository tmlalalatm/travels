package com.tm.travels.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tm.travels.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {


    /**
     * 根据用户名查询用户
     * @param userName
     * @return
     */
    User queryByUserName(String userName);

    /**
     *
     * @param user
     * @return
     */
    int insertSelective(User user);
}
