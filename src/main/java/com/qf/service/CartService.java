package com.qf.service;

import com.qf.pojo.Cart;
import com.qf.vo.VCart;

import java.util.List;

/**
 * @Description:
 * @Author: leilei
 * @Date: 2020/01/30/23:45
 */
public interface CartService {

    //查询所有购物车
    List<VCart> selectAllByUser(Integer userId);
    //查询所有购物车
    VCart selectAllPresent(Integer id);
    //根据商品id和用户id查询
    Cart selectByUserAndProduct(Integer productId, Integer userId);

    //根据id进行更新数据
    int updateByPrimaryKeySelective(Cart record);

    //根据id查询
    Cart selectByPrimaryKey(Integer id);

    //根据id进行数据删除
    int deleteByPrimaryKey(Integer id);
    //插入数据
    int insertSelective(Cart record);




}
