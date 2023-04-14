package com.h2.db.service;

import com.h2.db.model.Order;

import java.util.List;
public interface OrderService {
    Order saveOrder(Order order);
    Order fetchOrderByOrderId(Long orderId);
}
