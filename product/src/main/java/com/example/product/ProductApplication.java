package com.example.product;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaTemplate;

import com.google.gson.Gson;

@SpringBootApplication
public class ProductApplication {
	
	@Autowired
	ProductRepository ProductRepository;

	public static void main(String[] args) {
		SpringApplication.run(ProductApplication.class, args);
	}
	
	 @Bean
	    public NewTopic topic() {
	        return TopicBuilder.name("products")
	                .partitions(10)
	                .replicas(1)
	                .build();
	    }

	
	    @Bean
	    public ApplicationRunner runner(KafkaTemplate<String, String> template) {
	    	
	    	Gson gson = new Gson();
			 String prodlist = gson.toJson(ProductRepository.findAll());
	    	
	    	return args -> {
	    		template.send("products",prodlist);
	        };
	    }

}
