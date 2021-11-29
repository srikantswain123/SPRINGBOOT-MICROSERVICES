package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

import com.nt.model.Book;

@SpringBootApplication

@EnableBinding(Sink.class)
public class SpringCloudStreamKafkaConumserApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudStreamKafkaConumserApplication.class, args);
	}
	
	
	@StreamListener("input")
	public void read(Book book) {
		System.out.println(book.toString());
	}

}
