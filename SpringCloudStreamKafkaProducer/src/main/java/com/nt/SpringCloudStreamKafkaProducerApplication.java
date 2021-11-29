package com.nt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.PropertyMapper.Source;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nt.model.Book;

@SpringBootApplication
@RestController
@EnableBinding(Source.class)
public class SpringCloudStreamKafkaProducerApplication {
	
	@Autowired
	@Qualifier("output")
	private MessageChannel output;
	
	@PostMapping("/send")
	public Book sendMessage(@RequestBody Book book) {
		
		output.send(MessageBuilder.withPayload(book).build());
		
		return book;
	}
	
	
	

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudStreamKafkaProducerApplication.class, args);
	}

}
