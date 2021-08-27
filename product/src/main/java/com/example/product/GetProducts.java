package com.example.product;


import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;


public class GetProducts {
	@Autowired
	static
	ProductRepository ProductRepository;
	public static String showproducts(){
		
		
		
		Gson gson = new Gson();
		String json = gson.toJson(ProductRepository.findAll());
		
		return json;
	}
}
