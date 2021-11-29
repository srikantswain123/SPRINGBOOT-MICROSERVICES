package com.nt.address.rest;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/addRest")
public class AddressRest {
	
	@GetMapping("/msg")
	public String genreateMsg() {
		LocalDateTime dt=LocalDateTime.now();
		String msg="";
		int hour=dt.getHour();
		return hour<12?" Good morning":hour<16?" Good afternoon":hour<20?"Good evening":"Good night";
	}

}
