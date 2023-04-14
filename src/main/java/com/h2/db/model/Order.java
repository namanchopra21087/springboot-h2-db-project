package com.h2.db.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;

@Entity
@Table(name="Order")
public record Order(
        @Id @GeneratedValue(strategy = GenerationType.AUTO)Long OrderId,
        @NotNull String orderName,
        String sku,
        @NotNull  Integer quantity,
        @DecimalMin("0.00") @Digits(integer = 10,fraction = 2) BigDecimal cost
        ) {}
