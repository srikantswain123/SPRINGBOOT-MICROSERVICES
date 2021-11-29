package com.nt.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class ProducerService {
	@Autowired
	private KafkaTemplate<String,String> temp;
	
	@Value("${kafka.topic.name}")
	private String topicname;
	
	public void sendMsg(String msg) {
		temp.send(topicname, msg);
	}

}
