package com.library.ordering.controller;

import com.library.ordering.contants.AppConstants;
import com.library.ordering.dto.OrderRequestDto;
import com.library.ordering.dto.OrderResponseDto;
import com.library.ordering.service.OrderingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderingController {

  @Autowired
  OrderingService orderingService;

  @PostMapping(AppConstants.ORDERS)
  public ResponseEntity<OrderResponseDto> placeOrder(@RequestBody OrderRequestDto order) {
    OrderResponseDto response = orderingService.placeOrder(order);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }
}
