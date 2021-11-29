package com.nt.contract.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/csRest")
public class ContractRestController {
	
	@GetMapping("/con")
	public String getContractDetails() {
		return "get contract Details";
	}

}
