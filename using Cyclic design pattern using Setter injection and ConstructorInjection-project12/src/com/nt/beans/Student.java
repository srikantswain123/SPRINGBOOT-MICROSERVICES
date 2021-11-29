package com.nt.beans;

public class Student {
	private Person per;

	
	

	public Student(Person per) {
		System.out.println("Student::1-param cons");
		this.per = per;
	}




	@Override
	public String toString() {
		return "Student [per=  ]";
	}
	
	

}
