package com.nt.Test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.nt.beans.Flipkart;

public class StartegyTestWithSpring {
	public static void main(String[] args) {
		//hold the Spring bean cfg 
		Resource res=null;
		BeanFactory factory=null;
		//locate The Spring bean class
		res=new ClassPathResource("com/nt/cfgs/applicatioContext.xml");
		
		factory=new XmlBeanFactory(res);
	Flipkart fkt=factory.getBean("fkt",Flipkart.class);
	System.out.println(fkt.shopping(new String[] {"PPE","MASK","SANITIZER"},new float[] {100,300,400}));
	
	}

}
