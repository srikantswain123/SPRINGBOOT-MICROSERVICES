package com.nt.rest.provider;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.rest.model.Cart;

@RestController
@RequestMapping("/cartRest")
public class CartServiceRestController {
	
	@Value("${server.port}")
	private String port;
	
	  @GetMapping("/cartMsg")
	public String cartMsg() {
		return "from cart"+port;
	  }
	  @GetMapping("/getInfo/{name}")
	  public ResponseEntity<String> getMsgInfo(@PathVariable String name){
		  
		  return new ResponseEntity<String>(name, HttpStatus.OK);
	  }
	  @PostMapping("/createCart")
	  public Cart getCart(@RequestBody Cart cart) {
		  return cart;
	  }

}
