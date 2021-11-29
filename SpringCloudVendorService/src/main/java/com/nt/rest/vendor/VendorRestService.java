package com.nt.rest.vendor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.contract.consumer.ContractConsumer;

@RestController
@RequestMapping("/venRest")
public class VendorRestService {
	
	@Autowired
	private ContractConsumer consumer;
	@GetMapping("/result")
	public String vendorGetContractResult() {
		return "vendor contact=>"+consumer.getContarctDetails();
	}

}
