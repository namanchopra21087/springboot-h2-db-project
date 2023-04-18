package com.h2.db.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import lombok.Data;

@Data
public class OrderDto {
  Long orderId;
  @NotNull String orderName;
  @NotNull String sku;
  @NotNull Integer quantity;

  @DecimalMin("0.00")
  @Digits(integer = 10, fraction = 2)
  BigDecimal cost;
}
