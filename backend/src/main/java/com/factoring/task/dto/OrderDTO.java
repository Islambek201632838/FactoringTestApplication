package com.factoring.task.dto;

import jakarta.persistence.Column;

import java.math.BigDecimal;

public class OrderDTO {
    private int id;
    private String productName;
    private int productCount;
    private BigDecimal price;
}
