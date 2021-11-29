package com.nt.contract.consumer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ContractConsumer {
	@Autowired
	private DiscoveryClient client;
	
	public String getContarctDetails() {
		List<ServiceInstance> li=client.getInstances("CONTRACT-SERVICE");
		ServiceInstance si=li.get(0);
		String url=si.getUri()+"/csRest/con";
		RestTemplate rs=new RestTemplate();
		String result=rs.getForObject(url, String.class);
		return result;
	}

}
