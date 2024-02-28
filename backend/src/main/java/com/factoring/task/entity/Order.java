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

}
