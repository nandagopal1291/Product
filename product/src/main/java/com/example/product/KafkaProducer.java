package com.example.product;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;

public class KafkaProducer {
	private static KafkaTemplate<String, String> kafkaTemplate;
	
	public static void sendMessage(String message){
		ListenableFuture<SendResult<String, String>> result = kafkaTemplate.send("product",message);
        //return new ResponseEntity<>(result.get().getProducerRecord().value(), HttpStatus.OK);
	}

}
