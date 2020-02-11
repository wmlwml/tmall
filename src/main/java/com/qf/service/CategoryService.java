package com.qf.service;

import com.qf.pojo.Category;
import com.qf.pojo.Product;

import java.util.Map;

/**
 * @Description: 分类接口类
 * @Author: leilei
 * @Date: 2020/01/14/9:17
 */
public interface CategoryService {
    //查询所有
    Map<String,Object> findAll(Integer page, Integer limit, String searchInfo);

    //添加
    int addCategory(Category record);

    //更新分类数据
    int updateCategory(Category record);

    //删除单条数据
    int deleteCategory(Integer id);
    //删除多条数据
    int deleteByPrimaryKeys(String[] arr);




}
