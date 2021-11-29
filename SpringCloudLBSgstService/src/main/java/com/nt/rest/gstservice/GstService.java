package com.nt.rest.gstservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gstServ")
public class GstService {
	@Value("${server.port}")
	private String port;
	
	@GetMapping("/gen")
	public String generateGst() {
		return" from gstService"+port; 
	}

}
