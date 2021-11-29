package com.nt.address.consumer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class AddressConsumer {
	
	@Autowired
	private DiscoveryClient client;
	
	public String getMsgFromAddressProvider() {
		//get instance one instance of provider
		List<ServiceInstance> ins=client.getInstances("ADDRESS-REST");
		System.out.println("hello Srikant   "+ins);
		ServiceInstance si=ins.get(0);
		String url=si.getUri()+"/addRest"+"/msg";
		RestTemplate rt=new RestTemplate();
		String result=rt.getForObject(url,String.class);
		return result;
	}

}
