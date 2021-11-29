package com.nt.test;

import java.util.Scanner;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import com.nt.controller.MainControler;
import com.nt.service.CustomerMgmtService;
import com.nt.vo.CustomerVO;

public class CustomerDITest {

	public static void main(String[] args) {
	ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext();
	ConfigurableEnvironment env=ctx.getEnvironment();
	env.setActiveProfiles("dev");
	ctx.setConfigLocation("com/nt/cfgs/applicationContext.xml");
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
