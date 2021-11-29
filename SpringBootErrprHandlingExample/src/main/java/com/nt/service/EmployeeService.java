package com.nt.service;

import org.springframework.stereotype.Service;

import com.nt.exception.EmployeeException;
import com.nt.model.Employee;

@Service
public class EmployeeService {
	
	public Employee giveEmployeeDetails(int id) {
		if(id!=9)
			 throw new EmployeeException("EMployee not found exception "+id);
	return new Employee(10,"srikant", 70000.0f);
	}

}
