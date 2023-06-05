package com.h2.db.service;

import com.h2.db.dto.OrderDto;
import com.h2.db.entity.Order;
import com.h2.db.mapper.OrderMapper;
import com.h2.db.repo.OrderRepository;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
  private final OrderRepository repository;

  private final OrderMapper orderMapper;

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

  @Override
  public List<Order> fetchAll() {
    List<Order> orderList = repository.findAll();
    return orderList.stream()
        .filter(order -> order.getCost().compareTo(BigDecimal.TEN) > 0)
        .collect(Collectors.toList());
  }
}
