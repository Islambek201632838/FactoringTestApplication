package com.factoring.task.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "orders") //

public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_count")
    private int productCount;

    @Column(name = "price")
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
