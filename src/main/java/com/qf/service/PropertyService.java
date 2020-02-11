package com.qf.service;

import com.qf.pojo.Category;
import com.qf.pojo.Property;

import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: leilei
 * @Date: 2020/01/15/1:10
 */
public interface PropertyService {
    //查询所有
    Map<String, Object> findBycategory(Integer page, Integer limit, String searchInfo,Integer categoryId);

    //插入数据
    int insert(Property record);

    int deleteByPrimaryKey(Integer id);

    int updateByPrimaryKey(Property record);



}
