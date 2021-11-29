package com.nt.beans;

public class Person {
	
	private Student stu;

	

	public Person(Student stu) {
		System.out.println("Person:: 1 param constructor");
		this.stu = stu;
	}



	@Override
	public String toString() {
		return "Person [stu=" + stu + "]";
	}

	
	
		

}
