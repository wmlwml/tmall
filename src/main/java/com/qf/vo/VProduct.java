package com.qf.vo;

import com.qf.pojo.Category;

/**
 * @Description: 模型类
 * @Author: leilei
 * @Date: 2020/01/14/19:58
 */
public class VProduct {
    private Integer id;

    private String name;

    private String subTitle;

    private Float price;

    private Integer sale;

    private Integer stock;

    private Integer categoryId;
    private Category category;

    private Integer state;

    private String image;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getSale() {
        return sale;
    }

    public void setSale(Integer sale) {
        this.sale = sale;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "VProduct{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", subTitle='" + subTitle + '\'' +
                ", price=" + price +
                ", sale=" + sale +
                ", stock=" + stock +
                ", categoryId=" + categoryId +
                ", category=" + category +
                ", state=" + state +
                ", image='" + image + '\'' +
                '}';
    }
}