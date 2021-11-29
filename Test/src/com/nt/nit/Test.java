package com.nt.nit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class Test {
  public static void main(String[] args) {
	Example e=new Example();
	Example e12=new Example();
	e.setValue(13);
	e.setType("String");
	e12.setType("int");
	e12.setValue(39);
	List<Example> ex=new ArrayList();
	ex.add(e);
	ex.add(e12);
	
	//System.out.println(ex);
	
	List<Sample> se=new ArrayList();
	ListIterator<Example> li=ex.listIterator();
	while(li.hasNext()) {
		Example e1=li.next();
		Sample s=new Sample();
		s.setType(e1.getType());
		s.setValue(e1.getValue());
		se.add(s);
		
	}
	System.out.println(se);
	
	/*
	 * ListIterator<Sample> lis=se.listIterator(); while(lis.hasNext()) { Sample
	 * s1=lis.next(); System.out.println(s1.getType());
	 * System.out.println(s1.getValue()); }
	 */	
}
  
}
