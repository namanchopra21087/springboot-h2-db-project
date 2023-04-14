package com.h2.db.service;

import com.h2.db.model.Order;
import com.h2.db.repo.OrderRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.boot.web.servlet.filter.OrderedRequestContextFilter;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.MapBindingResult;
import org.springframework.validation.Validator;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class OrderServiceImpl implements OrderService{
    OrderRepository repository;

    @Override
    public Order saveOrder(Order order) {
        return repository.save(order);
    }

    @Override
    public Order fetchOrderByOrderId(Long orderId) {
        Optional<Order> orderOptional=repository.findById(orderId);
        return orderOptional.isPresent()?orderOptional.get():null;
    }
}
