package com.library.inventory.kafka;
import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.ErrorHandlingDeserializer;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.library.ordering.entity.Orders;


//package com.library.inventory.kafka;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import org.apache.kafka.clients.consumer.ConsumerConfig;
//import org.apache.kafka.common.serialization.StringDeserializer;
//import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.kafka.annotation.EnableKafka;
//import org.springframework.kafka.core.ConsumerFactory;
//import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
//import org.springframework.kafka.support.serializer.JsonSerializer;
//
//import com.library.inventory.dto.Orders;
//
//@Configuration
//@EnableKafka
//public class KafkaConfiguration {
//
//	private final String groupId = "";
//
//	@Bean
//	public ConsumerFactory<String, Orders> consumerFactory(KafkaProperties kafkaProperties) {
//		final Map<String, Object> props = new HashMap<>(); 
//		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
//		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, new JsonSerializer<>());
//		//return new DefaultKafkaConsumerFactory<>(kafkaProperties.buildConsumerProperties());
//		//return new DefaultKafkaConsumerFactory<>(configProps, new StringSerializer(), new JsonSerializer<>());
//		return new DefaultKafkaConsumerFactory<>(props);
//	}
//}

@Configuration
@EnableKafka
public class KafkaConfiguration {

    @Bean
    public ConsumerFactory<String, Orders> consumerFactory() {
        
        Map<String, Object> config = new HashMap<>();
        
        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
       // config.put(ConsumerConfig.GROUP_ID_CONFIG, "group_json");
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        //config.put(JsonSerializer.TYPE_MAPPINGS, "user:edu.kafka.test.model.User");
        //config.put(JsonDeserializer.VALUE_DEFAULT_TYPE, "edu.kafka.test.model.User");
        config.put(ErrorHandlingDeserializer.KEY_DESERIALIZER_CLASS, StringDeserializer.class);
        config.put(ErrorHandlingDeserializer.VALUE_DESERIALIZER_CLASS, JsonDeserializer.class);
        
        return new DefaultKafkaConsumerFactory<String, Orders>(config, new StringDeserializer(), new JsonDeserializer<>(Orders.class));
    }
    
    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Orders> kafkaLister() {
        
        ConcurrentKafkaListenerContainerFactory<String, Orders> factory = new ConcurrentKafkaListenerContainerFactory<>();
        
        factory.setMissingTopicsFatal(false);
        
        factory.setConsumerFactory(consumerFactory());
        
        return factory;
    }
    
}
