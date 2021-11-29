package com.nt.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.nt.beans.Person;
import com.nt.beans.Student;

public class SeterInjectionCyclicTest {

	public static void main(String[] args) {
		DefaultListableBeanFactory factory=new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader=new XmlBeanDefinitionReader(factory);
		
		
       //create spring contaier
      
      Person per=null;
      Student stu=null;
      reader.loadBeanDefinitions("com/nt/cfg/applicationContext.xml");
      per=factory.getBean("pers",Person.class);
      System.out.println(per);
		
		// stu=factory.getBean("stuu",Student.class); System.out.println(stu);
		 
	}

}
