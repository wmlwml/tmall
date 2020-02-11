package com.qf.service.impl;

import com.qf.mapper.OrderItemMapper;
import com.qf.pojo.Order;
import com.qf.pojo.OrderItem;
import com.qf.service.OrderItemService;
import com.qf.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Author: leilei
 * @Date: 2020/01/16/10:36
 */
@Service
public class OrderItemServiceImpl implements OrderItemService {

    @Autowired
    OrderItemMapper orderItemMapper;

    @Autowired
    ProductService productService;

    @Override
    public OrderItem getById(Integer id) {
        return null;
    }

    @Override
    public void add(OrderItem orderItem) {

    }

    @Override
    public int insertSelective(OrderItem record) {
        int i = orderItemMapper.insertSelective(record);
        return i;
    }

    @Override
    public List<OrderItem> getByOrderId(Integer order_id) {
        return null;
    }

    @Override
    public void update(OrderItem orderItem) {

    }

    @Override
    public List<OrderItem> listByUserId(Integer user_id) {
        return null;
    }

    @Override
    public List<OrderItem> listForCart(Integer user_id) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public void fill(List<Order> orders) {

    }

    @Override
    public void fill(Order o) {

    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        int i = orderItemMapper.deleteByPrimaryKey(id);

        return i;
    }
}
