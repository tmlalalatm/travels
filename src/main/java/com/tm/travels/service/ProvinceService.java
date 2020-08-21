package com.tm.travels.service;

import com.github.pagehelper.PageInfo;
import com.tm.travels.entity.Province;

import java.util.List;

/**
 * @Description:
 * @Author tangmin
 * @Date 2020/8/21 16:58
 **/
public interface ProvinceService {

    /**
     *start:当前页
     * counts:每页显示的条数
     */
    PageInfo<List<Province>> findByPage(Integer page, Integer rows);

    /**
     * 查询总条数
     */
    Integer findTotals();

    /**
     * 删除省份
     */
    void delete(String id);

    /**
     * 查询省份信息
     */
    Province findOne(String id);

    /**
     * 更新省份信息
     */
    void update(Province province);

}
