package com.nt.beans;

public class Person {

	private Student stu;

	

	public void setStu(Student stu) {
		System.out.println("using setter injection");
		this.stu = stu;
	}

	@Override
	public String toString() {
		return "Person [stu=" + stu + "]";
	}





}
