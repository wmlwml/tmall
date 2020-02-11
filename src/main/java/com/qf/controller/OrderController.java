package com.qf.controller;

import com.qf.common.JsonResult;
import com.qf.pojo.Order;
import com.qf.pojo.User;
import com.qf.service.OrderItemService;
import com.qf.service.OrderService;
import com.qf.util.StrUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;

/**
 * @Description: 订单控制器
 * @Author: leilei
 * @Date: 2020/01/16/11:15
 */
@Controller
@ResponseBody
@RequestMapping("order/")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderItemService orderItemService;

    //后端页面String orderIdKeyword,Date startDate,Date endDate,String orderState
    /**
     * 功能描述: <订单分页查询所有>
     *
     * @Param: [session, page, limit]
     * @Return: java.util.Map<java.lang.String,java.lang.Object>
     * @Author: Soulmate.leilei
     * @Date: 2020-2-2 13:07
     */
    @RequestMapping("findAll.do")
    public Map<String,Object> finAll(HttpSession session, Integer page, Integer limit
            ) {

        Map<String, Object> all = orderService.listAll(page, limit);
        return all;
    }

    /**
     * 功能描述: <订单发货>
     *
     * @Param: [orderId, expressNo]
     * @Return: java.lang.String
     * @Author: Soulmate.leilei
     * @Date: 2020-2-3 22:21
     */
    @RequestMapping("deliverOrder.do")
    public String deliverOrder(String orderId, String expressNo) {
        Order order = orderService.selectByCode(orderId);
        //快递单号
        order.setPost(expressNo);
        //订单状态
        order.setStatus("3");
        //发货日期
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        order.setDelivery_date(timestamp);

        int flag = orderService.updateByPrimaryKeySelective(order);
        if (flag > 0) {
            return "success";
        } else {
            return "fail";
        }

    }

    /**
     * 功能描述: <查看单个订单>
     *
     * @Param: [orderCode]
     * @Return: com.qf.common.JsonResult
     * @Author: Soulmate.leilei
     * @Date: 2020-2-5 17:00
     */
    @RequestMapping("findOrderById.do")
    public JsonResult findOrderById(String orderCode) {
        JsonResult jsonResult = null;
        try {
            Order order = orderService.selectByCode(orderCode);
            jsonResult = new JsonResult(1, order);
        } catch (Exception e) {
            jsonResult = new JsonResult(0, null);
        }

        return jsonResult;
    }

    /**
     * 功能描述: <删除订单>
     *
     * @Param: [id]
     * @Return: java.lang.String
     * @Author: Soulmate.leilei
     * @Date: 2020-2-5 17:24
     */
    @RequestMapping("deleteOrder.do")
    public String deleteOrder(Integer id){
        try {
            orderService.deleteByPrimaryKey(id);
            orderItemService.deleteByPrimaryKey(id);

            return "success";
        } catch (Exception e){

            return "fail";
        }
    }


    //前端页面
    /**
     * 功能描述: <订单查询>
     *
     * @Param: [session]
     * @Return: com.qf.common.JsonResult
     * @Author: Soulmate.leilei
     * @Date: 2020-2-2 13:08
     */
    @RequestMapping("paySuccess.do")
    public JsonResult paySuccess(HttpSession session) {
        String uuid = (String)session.getAttribute(StrUtils.UUID);
        //订单id
        Order order = orderService.selectByCode(uuid);

        return new JsonResult(1, order);


    }

    /**
     * 功能描述: <跟新订单状态>
     *
     * @Param: [session]
     * @Return: java.lang.String
     * @Author: Soulmate.leilei
     * @Date: 2020-2-2 13:25
     */
    @RequestMapping("paySuccessUpdate.do")
    public String paySuccessUpdate(HttpSession session) {
        //订单编号UUID
        String uuid = (String)session.getAttribute(StrUtils.UUID);
        //订单id
        Order opOrder = orderService.selectByCode(uuid);
        Integer orderId = opOrder.getId();


        Order order = new Order();
        order.setId(orderId);
        order.setStatus("2");
        //支付时间
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        order.setPay_date(timestamp);


        //移除当前操作订单UUID
        session.removeAttribute(StrUtils.UUID);
        //订单状态跟新
        int flag = orderService.updateByPrimaryKeySelective(order);
        if (flag > 0) {
            return "success";
        } else {
            return "fail";
        }

    }

    @RequestMapping("userOrderList.do")
    public JsonResult userOrderList(HttpSession session){
        User user = (User)session.getAttribute(StrUtils.LOGIN_USER);
        Integer userId = user.getId();


        return null;
    }

}
