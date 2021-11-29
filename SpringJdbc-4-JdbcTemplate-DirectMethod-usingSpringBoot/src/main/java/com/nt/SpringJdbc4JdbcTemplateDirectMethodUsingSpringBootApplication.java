package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nt.service.EmployeMgmtService;

@SpringBootApplication
public class SpringJdbc4JdbcTemplateDirectMethodUsingSpringBootApplication {

	public static void main(String[] args) {
		EmployeMgmtService service=null;
		ApplicationContext ctx=null;
		ctx=SpringApplication.run(SpringJdbc4JdbcTemplateDirectMethodUsingSpringBootApplication.class, args);
		service = ctx.getBean("service", EmployeMgmtService.class);
		try {
			System.out.println("Emp table contains " + service.fetchEmpCountOfRecord());
		} catch (DataAccessException dae) {
			dae.printStackTrace();
		}

		System.out.println();

		try {
			System.out.println("Employe names:" + service.fetchEmpName(7900));
		} catch (DataAccessException dae) {
			dae.printStackTrace();
		}

		System.out.println();

		try {
			System.out.println("Employe Details" + service.fetchEmpDetails(7900));
		} catch (DataAccessException dae) {
			dae.printStackTrace();
		}

		System.out.println();

		try {
			//System.out.println(service.fetchAllEmpDetails("MANAGER", "SALESMAN"));
			service.fetchAllEmpDetails("MANAGER", "SALESMAN").forEach(System.out::println);
		} catch (DataAccessException dae) {
			dae.printStackTrace();
		}
		
		System.out.println();

		try {
			System.out.println(service.insertEmpDetail("amitabh","aactor",50000.0f));
		} catch (DataAccessException dae) {
			dae.printStackTrace();
		}
		
		System.out.println();

		try {
			System.out.println(service.loadBonusByDesg("SALESMAN",2000.0f));
		} catch (DataAccessException dae) {
			dae.printStackTrace();
		}
		
		System.out.println();

		try {
			System.out.println(service.deleteEmpDetails(49));
		} catch (DataAccessException dae) {
			dae.printStackTrace();
		}

		((AbstractApplicationContext) ctx).close();

	
	
	
	
	
	
	
	
	
	
	
	}

}
