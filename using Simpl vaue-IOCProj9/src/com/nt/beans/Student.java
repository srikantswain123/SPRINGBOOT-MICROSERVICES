package com.nt.beans;

public class Student {
	private int sno;
	private String sname;
	private String addr;
	private float marks;
	
	public Student(int sno, String sname, String addr, float marks) {
		
		this.sno = sno;
		this.sname = sname;
		this.addr = addr;
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "Student [sno=" + sno + ", sname=" + sname + ", addr=" + addr + ", marks=" + marks + "]";
	}
	
	

}
