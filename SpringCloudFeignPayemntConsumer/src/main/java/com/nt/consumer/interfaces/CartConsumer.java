package com.nt.consumer.interfaces;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.nt.consumer.model.Cart;

@FeignClient("CART-SERVICE")
public interface CartConsumer {
	
	@GetMapping("/cartRest/cartMsg")
	public String cartMsg();
	
	@GetMapping("/cartRest/getInfo/{name}")
	  public ResponseEntity<String> getMsgInfo(@PathVariable String name);
		 
	 @PostMapping("/cartRest/createCart")
	  public Cart getCart(@RequestBody Cart cart);

}
