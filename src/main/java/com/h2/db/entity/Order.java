package com.h2.db.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "Order")
public record Order(
    @Id @GeneratedValue(strategy = GenerationType.AUTO) Long OrderId,
    String orderName,
    String sku,
    Integer quantity,
    BigDecimal cost) {}
