package com.nt.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.nt.util.MessageStore;

@Component
public class ConsumerService {
	@Autowired
	private MessageStore store;
	
	@KafkaListener(groupId = "groupid" ,topics ="sample" )
	public void readMsgFromproducer(String msg) {
		System.out.println(msg);
		store.storeMsg(msg);
	}

}
