package com.qf.service;

import com.qf.pojo.Order;
import com.qf.pojo.OrderItem;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface OrderService {

	String waitPay = "waitPay";
	String waitDelivery = "waitDelivery";
	String waitConfirm = "waitConfirm";
	String waitReview = "waitReview";
	String finish = "finish";
	String delete = "delete";

	/**
	 * 根据ID返回对应的Order
	 *
	 * @param id
	 * @return
	 */
	Order get(int id);
	//根据订单编号查询
	Order selectByCode(String order_code);

	/**
	 * 返回所有的订单
	 *
	 * @return
	 */
//	List<Order> listAll();
	Map<String, Object> listAll(Integer page, Integer limit);
	//Map<String,Object> findAll(Integer page, Integer limit, String searchInfo);



	/**
	 * 按照用户、订单状态来查询
	 *
	 * @param user_id
	 * @param excludedStatus
	 * @return
	 */
	List<Order> list(Integer user_id, String excludedStatus);

	/**
	 * 返回user_id下的所有订单
	 *
	 * @param user_id
	 * @return
	 */
	List<Order> listByUserId(Integer user_id);

	/**
	 * 更新订单
	 *
	 * @param order
	 */
	void update(Order order);
	int updateByPrimaryKeySelective(Order record);

	/**
	 * 增加订单
	 *
	 * @param order
	 */
	void add(Order order);
	int insertSelective(Order record);

	/**
	 * 增加订单，返回一个float类型的数值用来表示该订单的总价
	 *
	 * @param order
	 * @param orderItems
	 * @return
	 */
	float add(Order order, List<OrderItem> orderItems);


	int deleteByPrimaryKey(Integer id);
}
