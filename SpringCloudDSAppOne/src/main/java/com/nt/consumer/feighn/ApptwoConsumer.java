package com.nt.consumer.feighn;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("APP-TWO")
public interface ApptwoConsumer {
	
	
	@GetMapping("/show2")
	public String App2();

}
