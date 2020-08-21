package com.tm.travels.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tm.travels.dao.ProvinceMapper;
import com.tm.travels.entity.Province;
import com.tm.travels.service.ProvinceService;

import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author tangmin
 * @Date 2020/8/21 16:58
 **/
public class ProvinceServiceImpl extends ServiceImpl<ProvinceMapper,Province> implements ProvinceService {


    @Override
    public PageInfo<List<Province>> findByPage(Integer page, Integer rows) {
//        Page<Province> pages = PageHelper.startPage(page, rows);
//        List<Province> provinces =  baseMapper.findByPage();
//        PageInfo<List<Province>> pageInfo = PageInfoHelper.pageToPageInfo(pages, provinces);
//        return pageInfo;
        return null;
    }

    @Override
    public Integer findTotals() {
        return null;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public Province findOne(String id) {
        return null;
    }

    @Override
    public void update(Province province) {

    }
}
