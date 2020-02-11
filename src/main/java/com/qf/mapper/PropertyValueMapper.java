package com.qf.mapper;

import com.qf.pojo.PropertyValue;
import com.qf.vo.PropertyValueModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PropertyValueMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PropertyValue record);

    int insertSelective(PropertyValue record);

    PropertyValue selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PropertyValue record);

    int updateByPrimaryKey(PropertyValue record);

    //根据id查询 综合查询  模糊查询
    List<PropertyValueModel> selectFindAll(@Param("productId") Integer productId,
                                           @Param("searchInfo")String searchInfo);
//    Property selectByPrimaryKey(Property record);

}