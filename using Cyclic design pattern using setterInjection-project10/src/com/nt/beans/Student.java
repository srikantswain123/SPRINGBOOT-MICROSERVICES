package com.nt.beans;

public class Student {
	private Person per;

	public void setPer(Person per) {
		this.per = per;
	}

	@Override
	public String toString() {
		return "Student [per=" + per + "]";
	}
	
	

}
