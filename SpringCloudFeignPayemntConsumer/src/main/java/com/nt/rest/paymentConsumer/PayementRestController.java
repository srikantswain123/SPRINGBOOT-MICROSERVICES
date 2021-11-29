package com.nt.rest.paymentConsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.consumer.interfaces.CartConsumer;
import com.nt.consumer.model.Cart;

@RestController
@RequestMapping("/paymentRest")
public class PayementRestController {
	
	@Autowired
	private CartConsumer consumer;
	
	@GetMapping("/info")
	public String infoMsg() {
		return "from payemnt "+consumer.cartMsg();
	}
	
	@GetMapping("/msgInfo")
	public ResponseEntity<String> CreateMsgInfo(){
		return consumer.getMsgInfo("hello srikant");
	}
	
	@PostMapping("/create")
	public Cart createCart() {
	return consumer.getCart(new Cart("101","srikant",4578.0));
	}
}
