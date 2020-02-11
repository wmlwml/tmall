package com.qf.pojo;

public class PropertyValue {
    private Integer id;

    private Integer productId;

    private Integer propertyId;

    private String value;

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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }

    @Override
    public String toString() {
        return "PropertyValue{" +
                "id=" + id +
                ", productId=" + productId +
                ", propertyId=" + propertyId +
                ", value='" + value + '\'' +
                '}';
    }
}