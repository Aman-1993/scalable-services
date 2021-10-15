package com.library.inventory.kafka;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.library.inventory.entity.Inventory;
import com.library.inventory.repo.InventoryRepo;
import com.library.ordering.entity.Orders;

import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumer {

	@Autowired
	private InventoryRepo inventoryRepo;

	@KafkaListener(topics = "orders", groupId = "group_id")
	public void listenOrder(ConsumerRecord<String, Orders> message)
			throws JsonMappingException, JsonProcessingException {
		Orders orderResponseDto = (Orders) message.value();
		Long itemId = orderResponseDto.getItemId();
		Optional<Inventory> inventoryOpt = inventoryRepo.findById(itemId);
		if (inventoryOpt.isPresent()) {
			Inventory updatedInventory = inventoryOpt.get();
			Long quantity = updatedInventory.getQuantity() - 1;
			updatedInventory.setQuantity(quantity);
			inventoryRepo.save(updatedInventory);
			log.info("Inventory updated. The quantity for item {} is now {}", itemId, quantity);
		}
	}

}
