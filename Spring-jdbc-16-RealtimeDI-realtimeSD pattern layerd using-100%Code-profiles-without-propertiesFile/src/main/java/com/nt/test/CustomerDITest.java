package com.nt.test;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;

import com.nt.config.ConfigApp;
import com.nt.config.PersistentApp;
import com.nt.controller.MainControler;
import com.nt.vo.CustomerVO;

public class CustomerDITest {

	public static void main(String[] args) {
	AnnotationConfigApplicationContext ctx=null;
	ctx=new AnnotationConfigApplicationContext();
	ConfigurableEnvironment env= ctx.getEnvironment();
	env.setActiveProfiles("prod");
	ctx.register(ConfigApp.class);
	ctx.refresh();
	Scanner scn=null;
	scn=new Scanner(System.in);
	CustomerVO vo=null;
	vo=new CustomerVO();
	System.out.println("Enter customer Name");
	vo.setCname(scn.nextLine());
	
	System.out.println("Enter customer Address");
	vo.setCadd(scn.nextLine());
	System.out.println("Enter Principle Amount");
	vo.setPamt(scn.nextLine());
	System.out.println("Enter Rate of intrest");
	vo.setRtintrest(scn.nextLine());
	System.out.println("Enter year");
	vo.setTime(scn.nextLine());
	MainControler controler=ctx.getBean("mco",MainControler.class);
	try {
	System.out.println(controler.register(vo));
	}catch(Exception e) {
		e.printStackTrace();
	}
	
		
	}

}
