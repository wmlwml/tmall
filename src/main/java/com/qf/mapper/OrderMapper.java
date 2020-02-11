package com.qf.mapper;

import com.qf.pojo.Order;
import com.qf.pojo.OrderExample;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface OrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Order record);

    int insertSelective(Order record);

    List<Order> selectByExample(OrderExample example);


    Order selectByPrimaryKey(Integer id);
    //根据订单编号查询
    Order selectByCode(String order_code);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);
}