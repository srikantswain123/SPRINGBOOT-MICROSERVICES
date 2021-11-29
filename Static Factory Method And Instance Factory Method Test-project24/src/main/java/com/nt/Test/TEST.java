package com.nt.Test;

import java.util.Calendar;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

public class TEST {

	public static void main(String[] args) {
		
		DefaultListableBeanFactory factory=null;
		XmlBeanDefinitionReader reader=null;
		  factory=new DefaultListableBeanFactory();
		  reader=new XmlBeanDefinitionReader(factory);
		  reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");
		  Class c1=null;
		  c1=factory.getBean("c1",Class.class);
		  System.out.println(c1);
		  System.out.println(c1.getClass()+" "+c1.getClass().getName());
		  System.out.println("------------------------");
		  Calendar date=factory.getBean("date",Calendar.class);
		  System.out.println(date);
		  System.out.println(date.getClass()+"  "+date.getClass().getName());
		  System.out.println("--Instance Fcatory Method test");
		  String st=factory.getBean("st",String.class);
		  System.out.println(st);
		  String st1=factory.getBean("st1",String.class);
		  System.out.println(st1);
		  StringBuffer sb1=factory.getBean("sb1",StringBuffer.class);
		  System.out.println(sb1);
		  String sb2=factory.getBean("sb2",String.class);
		  System.out.println(sb2);

	}

}
