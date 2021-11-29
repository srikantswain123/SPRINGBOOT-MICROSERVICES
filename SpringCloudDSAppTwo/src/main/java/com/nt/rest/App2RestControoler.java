package com.nt.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.consumer.IneterfFeighn.App3Consumer;

@RestController
public class App2RestControoler {
	@Autowired
	private App3Consumer cons;
	
	
	private static final Logger log=LoggerFactory.getLogger(App2RestControoler.class);
	@GetMapping("/show2")
	public String App2() {
		log.info("welome to app2");
		String msg=cons.AppThreeMethod();
		log.info("Execution complete app2 "+ msg);
		return "done app2";
	}

}
