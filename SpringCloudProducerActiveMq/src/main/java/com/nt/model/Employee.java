package com.nt.model;

import java.io.Serializable;

public class Employee implements Serializable {
	
	private int id;
	private String name;
	private float bill;
	public Employee(int id, String name, float bill) {
		this.id = id;
		this.name = name;
		this.bill = bill;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", bill=" + bill + "]";
	}
	
	
	

}
