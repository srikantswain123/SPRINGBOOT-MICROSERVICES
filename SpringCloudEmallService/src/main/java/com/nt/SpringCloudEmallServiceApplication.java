package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringCloudEmallServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudEmallServiceApplication.class, args);
	}
	@GetMapping("/email")
	public String email() {
		return "email send suceceded";
	}

}
