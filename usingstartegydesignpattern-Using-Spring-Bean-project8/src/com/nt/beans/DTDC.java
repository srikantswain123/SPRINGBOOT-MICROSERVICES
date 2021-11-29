package com.nt.beans;

public class DTDC implements Courier {

	
	public DTDC() {
		System.out.println("DTDC constructor");
	}

	@Override
	public String deliver(int oid) {
		System.out.println("DTDC Courier");
		
		return "DTDC Courier will deliver  order id :: "+oid +" order  products";
	}

}
