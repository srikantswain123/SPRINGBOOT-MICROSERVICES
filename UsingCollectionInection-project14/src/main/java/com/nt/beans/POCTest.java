package com.nt.beans;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

public class POCTest {
	public static void main(String[] args) {
		DefaultListableBeanFactory factory=null;
		XmlBeanDefinitionReader reader=null;
		factory=new DefaultListableBeanFactory();
		reader=new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");
		University univers=factory.getBean("univer",University.class);
		System.out.println(univers);
		System.out.println("------------------------------------------");
		Employee e=factory.getBean("emp",Employee.class);
		System.out.println(e);
		System.out.println("-------------------------------------------");
		Employee e1=factory.getBean("emp1",Employee.class);
		System.out.println(e1);
		System.out.println("--------------------------------------------");
		DBdetails db=factory.getBean("db",DBdetails.class);
		System.out.println(db);
	}

}
