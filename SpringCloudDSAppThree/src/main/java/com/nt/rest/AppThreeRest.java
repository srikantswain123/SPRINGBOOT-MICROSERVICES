package com.nt.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppThreeRest {
	
	private static final Logger log=LoggerFactory.getLogger(AppThreeRest.class);
	
	@GetMapping("/show3")
	public String AppThreeMethod() {
		log.info("Welcome App3");
		
		return"Done App";
	}

}
