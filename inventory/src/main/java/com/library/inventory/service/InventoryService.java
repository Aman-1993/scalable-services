package com.library.inventory.service;

import com.library.inventory.kafka.KafkaConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class InventoryService {

  @Autowired
  RestTemplate restTemplate;

  @Autowired
  KafkaConsumer kafkaConsumer;

  public String placeOrder(OrderDto orderDto) {
    String response = restTemplate.postForObject("", null, String.class);


    return response;
  }
}
