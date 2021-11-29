package com.nt.beans;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

public class NullInjectionTest {
	public static void main(String[] args) {
		DefaultListableBeanFactory factory=null;
		XmlBeanDefinitionReader reader=null;
		Customer ravi=null,teja=null;
		//create Bean factory container
		factory=new DefaultListableBeanFactory();
		reader=new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");
		ravi=factory.getBean("ravi",Customer.class);
		System.out.println(ravi);
		System.out.println("-----------------------------");
		teja=factory.getBean("teja",Customer.class);
		System.out.println(teja);
	}

}
