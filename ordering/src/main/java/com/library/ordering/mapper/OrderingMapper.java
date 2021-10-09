package com.library.ordering.mapper;

import com.library.ordering.dto.OrderRequestDto;
import com.library.ordering.dto.OrderResponseDto;
import com.library.ordering.entity.Orders;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderingMapper {
  OrderRequestDto toOrderRequestDto(Orders orders);
  Orders toOrder(OrderRequestDto orderRequestDto);
  OrderResponseDto toOrderResponseDto(Orders orders);
}
