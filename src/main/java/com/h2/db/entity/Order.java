package com.h2.db.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "Order")
@Data
@Builder
public class Order {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  Long orderId;

  String orderName;
  String sku;
  Integer quantity;
  BigDecimal cost;
}
