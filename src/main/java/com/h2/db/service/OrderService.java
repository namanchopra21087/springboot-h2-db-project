package com.h2.db.service;

import com.h2.db.dto.OrderDto;
import com.h2.db.entity.Order;

public interface OrderService {
  Order saveOrder(OrderDto order);

  Order fetchOrderByOrderId(Long orderId);
}
