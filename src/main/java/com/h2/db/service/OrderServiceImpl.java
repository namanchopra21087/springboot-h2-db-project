package com.h2.db.service;

import com.h2.db.dto.OrderDto;
import com.h2.db.entity.Order;
import com.h2.db.mapper.OrderMapper;
import com.h2.db.repo.OrderRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class OrderServiceImpl implements OrderService {
  OrderRepository repository;

  OrderMapper orderMapper;

  @Override
  public Order saveOrder(OrderDto orderDto) {
    Order order = orderMapper.mapDtoToEntity(orderDto);
    return repository.save(order);
  }

  @Override
  public Order fetchOrderByOrderId(Long orderId) {
    Optional<Order> orderOptional = repository.findById(orderId);
    return orderOptional.isPresent() ? orderOptional.get() : null;
  }
}
