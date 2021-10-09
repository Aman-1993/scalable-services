package com.library.ordering.service;

import com.library.ordering.dto.OrderRequestDto;
import com.library.ordering.dto.OrderResponseDto;
import com.library.ordering.dto.PaymentRequestDto;
import com.library.ordering.dto.PaymentResponseDto;
import com.library.ordering.entity.Orders;
import com.library.ordering.kafka.KafkaProducer;
import com.library.ordering.mapper.OrderingMapper;
import com.library.ordering.repo.OrderingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderingService {

  @Autowired
  RestTemplate restTemplate;

  @Autowired
  KafkaProducer kafkaProducer;

  @Autowired
  OrderingRepo orderingRepo;

  @Autowired
  OrderingMapper mapper;

  @Value("${payment.service.url}")
  private String paymentServiceUrl;

  public OrderResponseDto placeOrder(OrderRequestDto orderRequestDto) {
    PaymentRequestDto paymentRequestDto = PaymentRequestDto.builder()
        .paymentAmount(orderRequestDto.getTotalAmount())
        .payerName(orderRequestDto.getPayerName())
        .build();
    PaymentResponseDto paymentResponse = restTemplate.postForObject(paymentServiceUrl,
        paymentRequestDto, PaymentResponseDto.class);

    orderRequestDto.setPaymentId(paymentResponse.getPaymentId());
    Orders order = mapper.toOrder(orderRequestDto);
    orderingRepo.save(order);
    kafkaProducer.produce(order);
    return mapper.toOrderResponseDto(order);
  }
}
