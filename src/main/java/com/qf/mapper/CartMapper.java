package com.qf.mapper;

import com.qf.pojo.Cart;
import com.qf.vo.VCart;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CartMapper {
    //根据id进行数据删除
    int deleteByPrimaryKey(Integer id);

    int insert(Cart record);

    //插入数据
    int insertSelective(Cart record);

    //根据id查询
    Cart selectByPrimaryKey(Integer id);

    //查询所有购物车
    List<VCart> selectAllByUser(Integer userId);
    //查询所有购物车
    VCart selectAllPresent(Integer id);
    //根据商品id和用户id查询
    Cart selectByUserAndProduct(@Param("productId") Integer productId, @Param("userId")Integer userId);


    //根据id进行更新数据
    int updateByPrimaryKeySelective(Cart record);

    int updateByPrimaryKey(Cart record);
}