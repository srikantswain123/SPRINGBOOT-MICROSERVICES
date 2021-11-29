package com.nt.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.nt.model.Employee;

@Component
public class ConsumerMq {
	
	
	@JmsListener(destination = "sample")
	public void readMsg(String sli) {
		System.out.println(sli);
	}

}
