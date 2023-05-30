package com.example.demo.b7;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.math.BigDecimal;


@Entity
public class Product {
    @Id
    @GeneratedValue
    private int ProductId;
    @Column
    private String productName;
    @Column
    private BigDecimal price;
    @Column
    private int quantity;


}
