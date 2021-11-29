package com.nt.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nt.dto.CustomerDto;
import com.nt.service.IcustomerService;

public class CallBackInterFaceTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		IcustomerService service=null;
		//create IOc container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		service=ctx.getBean("service",IcustomerService.class);
		try {
			System.out.println(service.fetchCustomerResult(101));
			
			
		}catch(DataAccessException dae) {
			dae.printStackTrace();
		}
		System.out.println("--------------------------------------------");
		try {
			List<CustomerDto> listDto=null;
			listDto=service.fetchCustomerResultsByAddrs("abudabi", "washington", "canda");
			listDto.forEach(System.out::println);
			
		}catch(DataAccessException dae) {
			dae.printStackTrace();
		}
		System.out.println("--------------------------------------------");
		try {
			List<CustomerDto> listDto=null;
			listDto=service.fetchCustomerResultsByAddrs1("abudabi", "washington", "canda");
			listDto.forEach(System.out::println);
			
		}catch(DataAccessException dae) {
			dae.printStackTrace();
		}

	}

}
