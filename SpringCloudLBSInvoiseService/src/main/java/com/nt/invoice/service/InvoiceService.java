package com.nt.invoice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.gstConsumer.GstConsumerService;

@RestController
@RequestMapping("/invService")
public class InvoiceService {
	
	@Autowired
	private GstConsumerService service;
	
	@GetMapping("/info")
	public String showInfo() {
		return "from invoice=>"+service.getGstInfo();
	}

}
