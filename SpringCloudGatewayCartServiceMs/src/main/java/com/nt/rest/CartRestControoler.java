package com.nt.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/con")
public class CartRestControoler {
	
	
	@Value("${server.port}")
	private String port;
	
	
	@GetMapping("/pay")
	public String msg() {
		return "from cart "+port;
	}

}
