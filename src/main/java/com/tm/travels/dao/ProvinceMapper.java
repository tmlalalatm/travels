package com.tm.travels.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tm.travels.entity.Province;

import java.util.List;

public interface ProvinceMapper extends BaseMapper<Province> {

    List<Province> findByPage();
}
