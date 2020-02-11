package com.qf.mapper;

import com.qf.pojo.Property;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PropertyMapper {
    int deleteByPrimaryKey(Integer id);

    //插入数据
    int insert(Property record);
    //插入数据
    int insertSelective(Property record);


    //根据id查询
    List<Property> selectByPrimaryKey(@Param("categoryId") Integer categoryId, @Param("searchInfo")String searchInfo);
//    Property selectByPrimaryKey(Property record);



    int updateByPrimaryKeySelective(Property record);

    int updateByPrimaryKey(Property record);


}