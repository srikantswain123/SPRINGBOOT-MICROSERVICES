package com.nt.gstConsumer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class GstConsumerService {
	@Autowired
	private LoadBalancerClient client;
	
	public String getGstInfo() {
		ServiceInstance si=client.choose("GST-SERVICE");
		String url=si.getUri()+"/gstServ/gen";
		//create Rest Template
		RestTemplate rt=new RestTemplate();
		String result=rt.getForObject(url, String.class);
		return result;
	}

}
