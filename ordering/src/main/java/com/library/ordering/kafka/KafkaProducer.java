package com.library.ordering.kafka;

import com.library.ordering.contants.AppConstants;
import com.library.ordering.entity.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

  @Autowired
  private KafkaTemplate<String, Orders> kafkaTemplate;

  public void produce(Orders message) {
    kafkaTemplate.send(AppConstants.TOPIC_SALES, message);
  }

}
