package com.nt.beans;

import java.util.Date;

public class Customer {
	private String cname;
	private int ano;
	private Date dob;
	private Date doj;
	private Date dom;
	public Customer(String cname, int ano, Date dob, Date doj, Date dom) {
		this.cname = cname;
		this.ano = ano;
		this.dob = dob;
		this.doj = doj;
		this.dom = dom;
	}
	@Override
	public String toString() {
		return "Customer [cname=" + cname + ", ano=" + ano + ", dob=" + dob + ", doj=" + doj + ", dom=" + dom + "]";
	}
	
	
	
	
	

}
