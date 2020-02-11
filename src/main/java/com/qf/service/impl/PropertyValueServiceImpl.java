package com.qf.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qf.mapper.PropertyValueMapper;
import com.qf.pojo.PropertyValue;
import com.qf.service.PropertyValueService;
import com.qf.vo.PropertyValueModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: 业务逻辑实现类
 * @Author: leilei
 * @Date: 2020/01/15/14:35
 */
@Service
public class PropertyValueServiceImpl implements PropertyValueService {
    //依赖注入
    @Autowired
    private PropertyValueMapper propertyValueMapper;

    @Override
    public Map<String, Object> findByProductId(Integer page, Integer limit, String searchInfo, Integer productId) {
        //设置页码
        PageHelper.startPage(page, limit);
        //进行查询
        List<PropertyValueModel> list = propertyValueMapper.selectFindAll(productId, searchInfo);
        //获取总记录数
        long total = ((Page) list).getTotal();
        HashMap<String, Object> map = new HashMap();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", total);
        map.put("data", list);
        return map;

    }

    //插入数据
    @Override
    public int insert(PropertyValue record) {
        int flag = propertyValueMapper.insertSelective(record);
        return flag;
    }

    //删除数据
    @Override
    public int deleteByPrimaryKey(Integer id) {
        int flag = propertyValueMapper.deleteByPrimaryKey(id);
        return flag;
    }

    //更新数据
    @Override
    public int updateByPrimaryKey(PropertyValue record) {
        int flag = propertyValueMapper.updateByPrimaryKeySelective(record);
        return flag;
    }
}
