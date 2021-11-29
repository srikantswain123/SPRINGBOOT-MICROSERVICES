package com.nt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AllController {
	
	@GetMapping("/employee")
	public String showEmploye() {
		return "employee";
	}
	
	@GetMapping("/admin")
	public String showAdmin() {
		return "admin";
	}
	
	@GetMapping("/student")
	public String showStudent() {
		return "student";
	}
	
	@GetMapping("/college")
	public String showCollege() {
		return "college";
	}
	
	

}
