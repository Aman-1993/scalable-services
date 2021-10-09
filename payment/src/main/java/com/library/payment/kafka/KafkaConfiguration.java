package com.library.payment.kafka;

import com.library.payment.contants.AppConstants;
import com.library.payment.entity.Payment;
import java.util.HashMap;
import java.util.Map;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

@Configuration
@EnableKafka
public class KafkaConfiguration {

  private final String groupId = "";

  @Bean
  public ProducerFactory<String, Payment> producerFactory() {
    Map<String, Object> configProps = new HashMap<>();
    return new DefaultKafkaProducerFactory<>(configProps);
  }

  @Bean
  public KafkaTemplate<String, Payment> kafkaTemplate() {
    KafkaTemplate<String, Payment> kafkaTemplate = new KafkaTemplate<>(producerFactory());
    kafkaTemplate.setDefaultTopic(AppConstants.TOPIC_SALES);
    return kafkaTemplate;
  }

}
