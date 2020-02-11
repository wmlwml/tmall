package com.qf.service.impl;

import com.qf.mapper.CartMapper;
import com.qf.pojo.Cart;
import com.qf.service.CartService;
import com.qf.vo.VCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Author: leilei
 * @Date: 2020/01/30/23:45
 */
@Service
public class CartServiceImpl implements CartService {
    //依赖注入\
    @Autowired
    private CartMapper cartMapper;

    //查询所有
    @Override
    public List<VCart> selectAllByUser(Integer userId) {
        List<VCart> list = cartMapper.selectAllByUser(userId);
        return list;
    }

    @Override
    public VCart selectAllPresent(Integer id) {
        VCart vCart = cartMapper.selectAllPresent(id);
        return vCart;
    }

    //根据id和用户id查询
    @Override
    public Cart selectByUserAndProduct(Integer productId, Integer userId) {
        Cart cart = cartMapper.selectByUserAndProduct(productId, userId);
        return cart;
    }

    //根据id进行跟新购物车
    @Override
    public int updateByPrimaryKeySelective(Cart record) {
        int flag = cartMapper.updateByPrimaryKeySelective(record);
        return flag;
    }

    //根据id查询购物车商品
    @Override
    public Cart selectByPrimaryKey(Integer id) {
        Cart cart = cartMapper.selectByPrimaryKey(id);
        return cart;
    }

    //删除购物车商品
    @Override
    public int deleteByPrimaryKey(Integer id) {
        int flag = cartMapper.deleteByPrimaryKey(id);

        return flag;
    }

    //添加购物车
    @Override
    public int insertSelective(Cart record) {

        int flag = 0;
        Cart cart = cartMapper.selectByUserAndProduct(record.getProductId(), record.getUserId());
        if (cart == null) {
            //购物车无数据，进行插入数据
            flag = cartMapper.insertSelective(record);
        } else {
            Integer newQuantity = record.getQuantity();
            Integer oldQuantity = cart.getQuantity();
            //新老数据进行相加
            record.setQuantity(newQuantity+oldQuantity);
            record.setId(cart.getId());

            //购物车有对应数据，进行更新数据
            flag = cartMapper.updateByPrimaryKeySelective(record);

        }


        return flag;
    }
}
