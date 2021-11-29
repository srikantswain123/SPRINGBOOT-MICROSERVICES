package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.nt.model.Employee;

@SpringBootApplication
public class SpringJdbc10ConfigurationPropertiesBulkApplication {

	public static void main(String[] args) {
		Employee emp=null;
		ApplicationContext ctx=null;
		ctx=SpringApplication.run(SpringJdbc10ConfigurationPropertiesBulkApplication.class, args);
		emp=ctx.getBean(Employee.class);
		System.out.println(emp);
	}

}
