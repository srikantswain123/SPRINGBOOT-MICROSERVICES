package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringCloudPaytmServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudPaytmServiceApplication.class, args);
	}
	@GetMapping("/pay")
	public String paytm() {
		return "payment sucedded";
	}

}
