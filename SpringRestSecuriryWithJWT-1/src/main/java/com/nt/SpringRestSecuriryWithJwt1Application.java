package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringRestSecuriryWithJwt1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestSecuriryWithJwt1Application.class, args);
	}

}
