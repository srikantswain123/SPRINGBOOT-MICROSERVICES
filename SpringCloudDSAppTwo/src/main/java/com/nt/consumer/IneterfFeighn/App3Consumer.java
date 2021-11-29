package com.nt.consumer.IneterfFeighn;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("APP-THREE")
public interface App3Consumer {
	
	
	@GetMapping("/show3")
	public String AppThreeMethod();

}
