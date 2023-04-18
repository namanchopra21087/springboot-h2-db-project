package com.h2.db.mapper;

import com.h2.db.dto.OrderDto;
import com.h2.db.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(
    componentModel = MappingConstants.ComponentModel.SPRING,
    unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderMapper {
  @Mapping(target = "orderId", ignore = true)
  Order mapDtoToEntity(OrderDto orderDto);

  OrderDto mapEntityToDto(Order order);
}
