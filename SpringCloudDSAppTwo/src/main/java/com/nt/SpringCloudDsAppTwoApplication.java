package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class SpringCloudDsAppTwoApplication {
static ApplicationContext ctx=null;
	public static void main(String[] args) {
		ctx=SpringApplication.run(SpringCloudDsAppTwoApplication.class, args);
	}
	
	@Bean
	public Sampler objSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}

}
