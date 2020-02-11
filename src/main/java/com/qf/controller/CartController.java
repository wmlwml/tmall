package com.qf.controller;

import com.qf.common.JsonResult;
import com.qf.pojo.*;
import com.qf.service.CartService;
import com.qf.service.OrderItemService;
import com.qf.service.OrderService;
import com.qf.service.ProductService;
import com.qf.util.StrUtils;
import com.qf.util.UUIDUtil;
import com.qf.vo.VCart;
import com.sun.tools.internal.ws.processor.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Struct;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Description: 购物车控制层
 * @Author: leilei
 * @Date: 2020/01/30/23:48
 */
@Controller
@ResponseBody
@Transactional
@RequestMapping("cart/")
public class CartController {
    //依赖注入
    @Autowired
    private CartService cartService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderItemService orderItemService;

    @Autowired
    private ProductService productService;

    private List<VCart> cartList = new ArrayList<>();

    /**
     * 功能描述: <查询用户购物车数据>
     *
     * @Param: [session]
     * @Return: com.qf.common.JsonResult
     * @Author: Soulmate.leilei
     * @Date: 2020-1-30 23:59
     */
    @RequestMapping("selectAllByUser.do")
    public JsonResult selectAllByUser(HttpSession session) {

        User user = (User)session.getAttribute(StrUtils.LOGIN_USER);
        List<VCart> list = cartService.selectAllByUser(user.getId());
        JsonResult jsonResult = null;
        if (list != null) {
            jsonResult = new JsonResult(1, list);
        } else {
            jsonResult = new JsonResult(0, list);
        }
        return jsonResult;
    }


    /**
     * 功能描述: <当前购物车商品数量>
     *
     * @Param: [session]
     * @Return: com.qf.common.JsonResult
     * @Author: Soulmate.leilei
     * @Date: 2020-2-2 1:37
     */
    @RequestMapping("selectCountByUser.do")
    public JsonResult selectCountByUser(HttpSession session) {
        User user = (User)session.getAttribute(StrUtils.LOGIN_USER);
        List<VCart> list = cartService.selectAllByUser(user.getId());
        int size = list.size();


        return new JsonResult(1,size);
    }





    /**
     * 功能描述: <购物车添加商品>
     *
     * @Param: [num, goodsId, session]
     * @Return: java.lang.String
     * @Author: Soulmate.leilei
     * @Date: 2020-2-1 15:39
     */
    @RequestMapping("addCart.do")
    public String addCart(Integer num, Integer goodsId,HttpSession session) {

        try {
            User user = (User) session.getAttribute(StrUtils.LOGIN_USER);
            Integer userId = user.getId();
            Cart cart = new Cart();
            cart.setQuantity(num);
            cart.setProductId(goodsId);
            cart.setUserId(userId);

            int flag = cartService.insertSelective(cart);
            if (flag > 0) {
                return "success";
            } else {
                return "fail";
            }
        } catch (Exception e) {
            return "exception";
        }

    }


    /**
     * 功能描述: <增加购物数量>
     *
     * @Param: [cartId]
     * @Return: java.lang.String
     * @Author: Soulmate.leilei
     * @Date: 2020-1-31 15:27
     */
    @RequestMapping("addCartNum.do")
    public String addCartNum(Integer cartId){
        //更改数量
        Cart cart = cartService.selectByPrimaryKey(cartId);
        cart.setQuantity(cart.getQuantity() + 1);
        int flag = cartService.updateByPrimaryKeySelective(cart);
        if (flag > 0) {
            return "success";
        } else {
            return "fail";
        }
    }


    /**
     * 功能描述: <减少购物数量>
     *
     * @Param: [cartId]
     * @Return: java.lang.String
     * @Author: Soulmate.leilei
     * @Date: 2020-1-31 15:27
     */
    @RequestMapping("reduceCartNum.do")
    public String reduceCartNum(Integer cartId) {
        Cart cart = cartService.selectByPrimaryKey(cartId);
        cart.setQuantity(cart.getQuantity()-1);
        int flag = cartService.updateByPrimaryKeySelective(cart);
        if (flag > 0) {
            return "success";
        } else {
            return "fail";
        }
    }

    /**
     * 功能描述: <删除购物车数据>
     *
     * @Param: [cartId]
     * @Return: java.lang.String
     * @Author: Soulmate.leilei
     * @Date: 2020-1-31 15:29
     */
    @RequestMapping("deleteCart.do")
    public String deleteCart(Integer cartId){
        int flag = cartService.deleteByPrimaryKey(cartId);
        if (flag > 0) {
            return "success";
        } else {
            return "fail";
        }

    }

    /**
     * 功能描述: <下单>
     *
     * @Param: [goodslist]
     * @Return: com.qf.common.JsonResult
     * @Author: Soulmate.leilei
     * @Date: 2020-2-1 1:25
     */
    @RequestMapping("preOrder.do")
    public JsonResult preOrder(Integer[] goodslist){

        //清空数据
        cartList.clear();
        //
        for (Integer i : goodslist) {
            VCart vCart = cartService.selectAllPresent(i);
            //存放订单数据
            cartList.add(vCart);
        }
        return new JsonResult(1,null);
    }

    /**
     * 功能描述: <结算>
     *
     * @Param: []
     * @Return: com.qf.common.JsonResult
     * @Author: Soulmate.leilei
     * @Date: 2020-2-1 1:29
     */
    @RequestMapping("presentOrder.do")
    public JsonResult presentOrder() {
        return new JsonResult(1, cartList);

    }


    @RequestMapping("takeOrderAdd.do")
    public String takeOrderAdd(String addr,HttpSession session) {
        Order order = new Order();
        //订单编号
        String uuid = UUIDUtil.getUUID();
        order.setOrder_code(uuid);
        session.setAttribute(StrUtils.UUID,uuid);
        //地址
        order.setAddress(addr);
        //用户名称
        User user = (User)session.getAttribute(StrUtils.LOGIN_USER);
        order.setReceiver(user.getName());
        //用户联系方式
        order.setMobile(user.getEmail());
        //订单创建时间
        Date date = new Date();
        //得到一个timestamp格式的时间，存入mysql中的时间格式为"yyyy-MM-dd HH:mm:ss"
        Timestamp timestamp = new Timestamp(date.getTime());
        order.setCreate_date(timestamp);
        //用户id
        order.setUser_id(user.getId());
        //订单状态
        order.setStatus("1");
        //插入订单主表数据
        int flag = orderService.insertSelective(order);

        if (flag > 0) {
            //订单id
            Order order1 = orderService.selectByCode(uuid);
            Integer orderId = order1.getId();


            //取出从表所需要的数据
            for (VCart vCart : cartList) {

                Integer productId = vCart.getProduct().getId();
                Integer cartNum = vCart.getCartNum();
                OrderItem orderItem = new OrderItem();
                orderItem.setOrder_id(orderId);
                orderItem.setProduct_id(productId);
                orderItem.setNumber(cartNum);
                orderItem.setUser_id(user.getId());

                //插入订单从表 数据
                orderItemService.insertSelective(orderItem);
                //商品销量 库存操作
                Product product = productService.findById(productId);
                Integer sale = product.getSale();
                Integer stock = product.getStock();
                //销量增加
                product.setSale(sale + cartNum);
                //k库存减少
                product.setStock(stock - cartNum);

                productService.updateById(product);


                //删除对应购物车数据
                 cartService.deleteByPrimaryKey(vCart.getCartId());
            }
            return "success";
        } else {
            return "fail";
        }

    }








}
