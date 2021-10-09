package com.library.payment.kafka;

import com.library.payment.contants.AppConstants;
import com.library.payment.entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

  @Autowired
  private KafkaTemplate<String, Payment> kafkaTemplate;

  public void produce(Payment message) {
    kafkaTemplate.send(AppConstants.TOPIC_SALES, message);
  }

}
