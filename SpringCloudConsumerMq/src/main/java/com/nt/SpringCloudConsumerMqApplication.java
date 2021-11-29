package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class SpringCloudConsumerMqApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudConsumerMqApplication.class, args);
	}

}
