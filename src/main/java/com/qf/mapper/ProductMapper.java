package com.qf.mapper;

import com.qf.pojo.Product;
import com.qf.vo.VProduct;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Product record);

    //插入数据
    int insertSelective(Product record);

    Product selectByPrimaryKey(Integer id);

    //更新单个数据
    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);


    //查询所有商品信息
    List<VProduct> findAll(@Param("searchInfo")String searchInfo);
}