package com.h2.db.controller;

import com.h2.db.dto.OrderDto;
import com.h2.db.entity.Order;
import com.h2.db.service.OrderService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
@NoArgsConstructor
public class OrderController {

  OrderService orderService;

  @PostMapping(
      value = "/order",
      consumes = {MediaType.APPLICATION_JSON_VALUE},
      produces = {MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity createOrder(@Valid @RequestBody OrderDto orderDto) {
    Order result = orderService.saveOrder(orderDto);
    return new ResponseEntity(result, HttpStatus.OK);
  }

  @GetMapping(
      value = "/",
      consumes = {MediaType.APPLICATION_JSON_VALUE},
      produces = {MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity fetchOrderByOrderId(@PathVariable @NotNull Long orderId) {
    Order result = orderService.fetchOrderByOrderId(orderId);
    return new ResponseEntity(result, HttpStatus.OK);
  }
}
