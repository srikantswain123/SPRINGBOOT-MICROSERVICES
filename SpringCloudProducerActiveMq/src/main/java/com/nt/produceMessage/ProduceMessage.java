package com.nt.produceMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.nt.model.Employee;

@Component
public class ProduceMessage {
	
	@Autowired
	private JmsTemplate tm;
	@Value("${my.acti.my.name}")
	private String destinanme;
	
	@Scheduled(cron = "*/20 * * * * *")
	public void sendMessage() {
		
		tm.send(destinanme, ses->ses.createObjectMessage(new Employee(101, "srikant", 1546.0f)));
	}

}
