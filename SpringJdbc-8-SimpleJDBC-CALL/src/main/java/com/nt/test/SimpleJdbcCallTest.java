package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nt.service.ILoginServiceMgmt;

public class SimpleJdbcCallTest {

	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		ILoginServiceMgmt service=ctx.getBean("service",ILoginServiceMgmt.class);
		try {
		  System.out.println(service.loginValidator("raja", "rani"));
		}catch(DataAccessException dae) {
			dae.printStackTrace();
		}
		
		((AbstractApplicationContext) ctx).close();
		

	}

}
