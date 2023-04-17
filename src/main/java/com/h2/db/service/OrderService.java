package com.h2.db.service;

import com.h2.db.entity.Order;

public interface OrderService {
  Order saveOrder(Order order);

  Order fetchOrderByOrderId(Long orderId);
}
