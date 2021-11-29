package com.nt;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringCloudActuatorPocApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudActuatorPocApplication.class, args);
	}
	
	@Bean
	@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public RestTemplate rt() {
		return new RestTemplate();
	}

}
