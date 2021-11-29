package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nt.dto.BankAccountDto;
import com.nt.service.IBankAccountService;

public class SimpleJdbcInsertTest {

	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		IBankAccountService service=ctx.getBean("bankService",IBankAccountService.class);
		try {
		   BankAccountDto dto=new BankAccountDto();
		   dto.setAcno(10500000l);
		   dto.setHoldername("suba raju");
		   dto.setBalance(48684.0f);
		   dto.setStatus("Active");
		   System.out.println(service.registerAccount(dto));
		   
		}catch(DataAccessException dae) {
			dae.printStackTrace();
		}
		
		((AbstractApplicationContext) ctx).close();
		

	}

}
