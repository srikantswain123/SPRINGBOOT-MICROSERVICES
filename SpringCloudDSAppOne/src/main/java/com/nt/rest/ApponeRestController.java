package com.nt.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.consumer.feighn.ApptwoConsumer;


@RestController
public class ApponeRestController {
	@Autowired
	private ApptwoConsumer cons;
	  Logger log=LoggerFactory.getLogger(ApponeRestController.class); 
	@GetMapping("/show1")
	public String Appone() {
		log.info("WELOCME TO APP ONE");
		String msg=cons.App2();
		log.info("Execution complete APP ONE "+msg);
		return "done app1";
	}

}
