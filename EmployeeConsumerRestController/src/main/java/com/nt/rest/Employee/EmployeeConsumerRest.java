package com.nt.rest.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.address.consumer.AddressConsumer;

@RestController
@RequestMapping("/empRest")
public class EmployeeConsumerRest {
	@Autowired
	private AddressConsumer consumer;

	@GetMapping("/genMsg")
	public String generateWishMsg() {
		System.out.println("hello msg ");
		return "hello"+consumer.getMsgFromAddressProvider();
	}
}
