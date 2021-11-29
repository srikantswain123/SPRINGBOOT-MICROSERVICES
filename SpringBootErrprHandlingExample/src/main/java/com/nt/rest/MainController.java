package com.nt.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.nt.model.Employee;
import com.nt.service.EmployeeService;

@RestController
public class MainController {
	@Autowired
	private EmployeeService service;
	
	@GetMapping("/emp/{id}")
	public Employee showEmpDetails(@PathVariable int id) {
		return service.giveEmployeeDetails(id);
	}
	
	@GetMapping("/hello")
	public String msg() {
		return "hello";
	}
	
	
	

}
