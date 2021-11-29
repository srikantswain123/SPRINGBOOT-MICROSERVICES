package com.nt.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nt.producer.ProducerService;
import com.nt.util.MessageStore;

@RestController
public class SenderAndReciverControler {
	
	@Autowired
	private ProducerService service;
	@Autowired
	private MessageStore store;
	
	@GetMapping("/send")
	public String sendMesage(@RequestParam String name) {
		service.sendMsg(name);
		System.out.println("sucessfully sent");
		return "sucessfully send";
	}
	
	@GetMapping("/read")
	public String readMessage() {
		System.out.println(store.readMsg());
		return store.readMsg();
	}

}
