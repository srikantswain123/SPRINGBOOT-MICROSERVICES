package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nt.dto.EmployeeDto;
import com.nt.service.IEmployeService;

public class NamedParmeterJdbcTemplate {

	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		IEmployeService service=null;
		try {
			service=ctx.getBean("empService",IEmployeService.class);
			System.out.println("EmployeeName::"+service.fetchEmployeNameByNo(7499));
		}//try
		catch(DataAccessException dae) {
			dae.printStackTrace();
			
		}//catch
		System.out.println("----------------------------------------------------------------");
		try {
			System.out.println("get Employee Result BY desg");
			service.fetchEmployeDataByDesg("CLERK", "ANALYST","MANAGER").forEach(System.out::println);
			
		}//try
		catch(DataAccessException dae) {
			dae.printStackTrace();
		}//catch
		System.out.println("----------------------------------------------------------------");
		try {
			EmployeeDto dto=new EmployeeDto();
			dto.setEmpno(7999);
			dto.setEmpname("Mohit");
			dto.setJob("Devloper");
			dto.setSal(78456);
			System.out.println(service.InsertRecordIntoEmployee(dto));
			
		}//try
		catch(DataAccessException dae) {
			dae.printStackTrace();
		}//catch
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		((AbstractApplicationContext) ctx).close();

	}//main

}//class
