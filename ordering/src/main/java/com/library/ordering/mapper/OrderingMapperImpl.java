package com.library.ordering.mapper;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.library.ordering.dto.OrderRequestDto;
import com.library.ordering.dto.OrderResponseDto;
import com.library.ordering.entity.Orders;


@Service
public class OrderingMapperImpl implements OrderingMapper {

    @Override
    public OrderRequestDto toOrderRequestDto(Orders orders) {
        if ( orders == null ) {
            return null;
        }

        OrderRequestDto orderRequestDto = new OrderRequestDto();

        orderRequestDto.setItemId( orders.getItemId() );
        orderRequestDto.setPaymentId( orders.getPaymentId() );

        return orderRequestDto;
    }

    @Override
    public Orders toOrder(OrderRequestDto orderRequestDto) {
        if ( orderRequestDto == null ) {
            return null;
        }

        Orders orders = new Orders();

        orders.setItemId( orderRequestDto.getItemId() );
        orders.setPaymentId( orderRequestDto.getPaymentId() );
        orders.setAmount(orderRequestDto.getTotalAmount());
        orders.setCreatedAt(new Date());
        orders.setLastUpdatedAt(new Date());
        orders.setPayer(orderRequestDto.getPayerName());

        return orders;
    }

    @Override
    public OrderResponseDto toOrderResponseDto(Orders orders) {
        if ( orders == null ) {
            return null;
        }

        OrderResponseDto orderResponseDto = new OrderResponseDto();

        orderResponseDto.setId( orders.getId() );
        orderResponseDto.setItemId( orders.getItemId() );
        orderResponseDto.setAmount( orders.getAmount() );
        orderResponseDto.setCreatedAt( orders.getCreatedAt() );
        orderResponseDto.setLastUpdatedAt( orders.getLastUpdatedAt() );

        return orderResponseDto;
    }
}
