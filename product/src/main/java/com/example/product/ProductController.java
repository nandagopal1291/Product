package com.example.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Template;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import org.springframework.kafka.core.KafkaTemplate;
@RestController
public class ProductController {
	@Autowired
	ProductRepository ProductRepository;
	
	@Autowired
	CartRepository CartRepository;
	
	private final TransactionProducer TproducerService;
	 @Autowired
	    public ProductController(TransactionProducer producerService) 
	    {
	        this.TproducerService = producerService;
	    }

	
	@PostMapping("/cart/add")
	public Cart addCart(@Valid @RequestBody Cart addProduct) {
		
		CartRepository.save(addProduct);
		return  addProduct;
	}
	@GetMapping("/cart/{id}")
	public List<Cart> findById1(@PathVariable("id") String transactionid) {
      
		return CartRepository.findBytransactionid(transactionid);
	}

	@GetMapping("/product/all")
	public List<Product> getProduct() {

		return ProductRepository.findAll();

	}

	@GetMapping("/product/{id}")
	public Optional<Product> findById(@PathVariable("id") Long id) {

		return ProductRepository.findById(id);
	}
	@PostMapping("/transaction/{userid}/{transactionid}")
	public Status AddTransaction(@PathVariable("userid") String userid,@PathVariable("transactionid") String transactionid){
		String message="{\"transactionid\":\""+transactionid+"\",\"userid\":\""+userid+"\"}";
		this.TproducerService.sendMessage(message);
		return Status.SUCCESS;
		
	}
}