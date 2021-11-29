package com.nt.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/prs")
public class ProductRestController {
	
	@Autowired
	private RestTemplate rt;
	
	@GetMapping("/prod")
	public String formProduct() {
		return "hello from rest";
	}

}
