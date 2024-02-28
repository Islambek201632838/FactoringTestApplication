package com.factoring.task.dto;

import jakarta.persistence.Column;

import java.math.BigDecimal;

public class OrderDTO {
    private int id;
    private String productName;
    private int productCount;
    private BigDecimal price;

    public int getId() {
        return id;
    }
    public String getProductName() {
        return productName;
    }
    public int getProductCount() {
        return productCount;
    }
    public BigDecimal getPrice() {
        return price;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }


}
