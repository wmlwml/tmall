package com.qf.vo;

import com.qf.pojo.Product;
import com.qf.pojo.User;

/**
 * @Description: 购物车视图类
 * @Author: leilei
 * @Date: 2020/01/30/18:48
 */
public class VCart {

    private Integer cartId;
    private Integer checked;
    private Integer cartNum;
    private Double cartPrice;

    private Product product;
    private User cartUser;

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public Integer getChecked() {
        return checked;
    }

    public void setChecked(Integer checked) {
        this.checked = checked;
    }

    @Override
    public String toString() {
        return "VCart{" +
                "cartId=" + cartId +
                ", checked=" + checked +
                ", cartNum=" + cartNum +
                ", cartPrice=" + cartPrice +
                ", product=" + product +
                ", cartUser=" + cartUser +
                '}';
    }

    public Integer getCartNum() {
        return cartNum;
    }

    public void setCartNum(Integer cartNum) {
        this.cartNum = cartNum;
    }

    public Double getCartPrice() {
        return cartPrice;
    }

    public void setCartPrice(Double cartPrice) {
        this.cartPrice = cartPrice;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public User getCartUser() {
        return cartUser;
    }

    public void setCartUser(User cartUser) {
        this.cartUser = cartUser;
    }
}
