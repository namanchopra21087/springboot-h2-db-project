package com.h2.db.service;

import com.h2.db.entity.Order;
import com.h2.db.repo.OrderRepository;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class OrderServiceImpl implements OrderService {
  OrderRepository repository;

  @Override
  public Order saveOrder(Order order) {
    return repository.save(order);
  }

  @Override
  public Order fetchOrderByOrderId(Long orderId) {
    Optional<Order> orderOptional = repository.findById(orderId);
    return orderOptional.isPresent() ? orderOptional.get() : null;
  }
}
