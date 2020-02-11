package com.qf.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qf.mapper.OrderMapper;
import com.qf.pojo.Order;
import com.qf.pojo.OrderExample;
import com.qf.pojo.OrderItem;
import com.qf.service.OrderItemService;
import com.qf.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * OrderService 实现类
 *
 * @author:
 * @create:
 */
@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderMapper orderMapper;

	@Autowired
	OrderItemService orderItemService;

	@Override
	public Order get(int id) {
		return orderMapper.selectByPrimaryKey(id);
	}

	//根据订单编号查询
	@Override
	public Order selectByCode(String order_code) {
		Order order = orderMapper.selectByCode(order_code);

		return order;
	}

//	@Override
//	public List<Order> listAll() {
//		OrderExample example = new OrderExample();
//		return orderMapper.selectByExample(example);
//	}

	//分页查询
	@Override
	public Map<String, Object> listAll(Integer page, Integer limit
			) {

		OrderExample example = new OrderExample();
		//设置页码
		PageHelper.startPage(page, limit);
		List<Order> list = orderMapper.selectByExample(example);
		//获取总记录数
		long total = ((Page) list).getTotal();
		HashMap<String, Object> map = new HashMap();
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", total);
		map.put("data", list);
		return map;
	}

	@Override
	public List<Order> list(Integer user_id, String excludedStatus) {
		OrderExample example = new OrderExample();
		example.or().andUser_idEqualTo(user_id).andStatusNotEqualTo(excludedStatus);
		example.setOrderByClause("id desc");
		return orderMapper.selectByExample(example);
	}

	@Override
	public List<Order> listByUserId(Integer user_id) {
		OrderExample example = new OrderExample();
		example.or().andUser_idEqualTo(user_id);
		return orderMapper.selectByExample(example);
	}

	@Override
	public void update(Order order) {
		orderMapper.updateByPrimaryKey(order);
	}

	@Override
	public int updateByPrimaryKeySelective(Order record) {
		int flag = orderMapper.updateByPrimaryKeySelective(record);

		return flag;
	}

	@Override
	public void add(Order c) {
		orderMapper.insert(c);
	}

	//插入数据
	@Override
	public int insertSelective(Order record) {
		int flag = orderMapper.insertSelective(record);
		return flag;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackForClassName = "Exception")
	public float add(Order order, List<OrderItem> orderItems) {
		float total = 0;
		add(order);

		// 用来模拟当增加订单后出现异常，观察事务管理是否预期发生
		if (false)
			throw new RuntimeException();

		for (OrderItem oi : orderItems) {
			oi.setOrder_id(order.getId());
			orderItemService.update(oi);
			total += oi.getProduct().getPrice() * oi.getNumber();
		}
		return total;
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		int i = orderMapper.deleteByPrimaryKey(id);

		return i;
	}
}
