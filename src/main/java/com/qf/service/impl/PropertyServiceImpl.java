package com.qf.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qf.mapper.CategoryMapper;
import com.qf.mapper.PropertyMapper;
import com.qf.pojo.Category;
import com.qf.pojo.Property;
import com.qf.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: leilei
 * @Date: 2020/01/15/1:11
 */
@Service
public class PropertyServiceImpl implements PropertyService {
    @Autowired
    private PropertyMapper propertyMapper;



    @Override
    public Map<String, Object> findBycategory(Integer page, Integer limit, String searchInfo,Integer id) {
        Integer categoryId = id;
        //设置页码
        PageHelper.startPage(page, limit);
        //进行查询
        List<Property> list = propertyMapper.selectByPrimaryKey(categoryId, searchInfo);
        //获取总记录数
        long total = ((Page) list).getTotal();
        HashMap<String, Object> map = new HashMap();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", total);
        map.put("data", list);
        return map;
    }

    @Override
    public int insert(Property record) {
        int i = propertyMapper.insertSelective(record);
        return i;
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        int i = propertyMapper.deleteByPrimaryKey(id);
        return i;
    }

    @Override
    public int updateByPrimaryKey(Property record) {
        int i = propertyMapper.updateByPrimaryKeySelective(record);
        return i;
    }


}
