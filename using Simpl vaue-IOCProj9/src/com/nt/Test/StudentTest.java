package com.nt.Test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.nt.beans.Student;

public class StudentTest {

	public static void main(String[] args) {
		BeanFactory factory=null;
		Student st=null;
	     factory=new XmlBeanFactory(new ClassPathResource("com/nt/cfgs/applicationContext.xml"));
	     st=factory.getBean("stu",Student.class);
	     System.out.println(st);

	}

}
