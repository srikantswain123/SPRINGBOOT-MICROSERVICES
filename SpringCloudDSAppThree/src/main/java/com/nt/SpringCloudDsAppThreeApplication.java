package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringCloudDsAppThreeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudDsAppThreeApplication.class, args);
	}
	
	@Bean
	public Sampler objSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}

}
