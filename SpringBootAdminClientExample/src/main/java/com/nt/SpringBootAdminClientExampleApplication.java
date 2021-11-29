package com.nt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication

public class SpringBootAdminClientExampleApplication {
	
	@Autowired
	private RestTemplate rt;
	

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAdminClientExampleApplication.class, args);
	}
	
	@Bean
	public RestTemplate rt() {
		return new RestTemplate();
	}

}
