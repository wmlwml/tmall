package com.qf.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qf.mapper.CategoryMapper;
import com.qf.mapper.UserMapper;
import com.qf.pojo.Category;
import com.qf.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: 分类接口实现类
 * @Author: leilei
 * @Date: 2020/01/14/9:18
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    //依赖注入
    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public Map<String, Object> findAll(Integer page, Integer limit, String searchInfo) {
        //设置页码
        PageHelper.startPage(page, limit);
        //进行查询
        List<Category> list = categoryMapper.findAll(searchInfo);
        //获取总记录数
        long total = ((Page) list).getTotal();
        HashMap<String, Object> map = new HashMap();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", total);
        map.put("data", list);

        return map;
    }

    //增加
    @Override
    public int addCategory(Category record) {
        int flag = categoryMapper.insertSelective(record);
        return flag;
    }

    //更新
    @Override
    public int updateCategory(Category record) {
        int flag = categoryMapper.updateByPrimaryKeySelective(record);
        return flag;
    }

    //删除数据
    @Override
    public int deleteCategory(Integer id) {
        int flag = categoryMapper.deleteByPrimaryKey(id);
        return flag;
    }


    //删除多条数据
    @Override
    public int deleteByPrimaryKeys(String[] arr) {
        int i = categoryMapper.deleteByPrimaryKeys(arr);
        return i;


    }
}
