package com.qf.vo;

/**
 * @Description: 属性值视图类
 * @Author: leilei
 * @Date: 2020/01/15/14:06
 */
public class PropertyValueModel {
    private Integer id;
    private Integer productId;
    private Integer propertyId;
    private String propertyName;
    private String propertyValue;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Integer propertyId) {
        this.propertyId = propertyId;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getPropertyValue() {
        return propertyValue;
    }

    public void setPropertyValue(String propertyValue) {
        this.propertyValue = propertyValue;
    }

    @Override
    public String toString() {
        return "VPropertyValue{" +
                "id=" + id +
                ", productId=" + productId +
                ", propertyId=" + propertyId +
                ", propertyName='" + propertyName + '\'' +
                ", propertyValue='" + propertyValue + '\'' +
                '}';
    }
}
