package com.h2.db.mapper;

import com.h2.db.dto.OrderDto;
import com.h2.db.entity.Order;
import org.mapstruct.Mapper;

@Mapper
public interface OrderMapper {
  Order mapDtoToEntity(OrderDto orderDto);

  OrderDto mapEntityToDto(Order order);
}
