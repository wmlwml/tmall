package com.qf.mapper;

import com.qf.pojo.Category;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CategoryMapper {
    //删除单条数据
    int deleteByPrimaryKey(Integer id);


    //删除多条数据
    int deleteByPrimaryKeys(String[] arr);


    int insert(Category record);
    //添加
    int insertSelective(Category record);

    Category selectByPrimaryKey(Integer id);

    //更新分类数据
    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);

    //综合查询
     List<Category> findAll(@Param("searchInfo")String searchInfo);
}