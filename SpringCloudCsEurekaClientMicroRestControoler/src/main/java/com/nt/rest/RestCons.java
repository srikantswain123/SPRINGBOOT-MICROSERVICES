package com.nt.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class RestCons {
	
	@Value("${title}")
	public String msg;
	
	@GetMapping("/msg")
	public String genMsg() {
		return "hello"+msg;
	}

}
