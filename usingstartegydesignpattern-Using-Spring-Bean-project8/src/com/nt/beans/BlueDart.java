package com.nt.beans;

public class BlueDart implements Courier {
	

	public BlueDart() {
		System.out.println("BLUE dart Constructor");
	}

	@Override
	public String deliver(int oid) {
		System.out.println("using BlueDart courier");
		
		return "BlueDArt Courier will deliver  order id :: "+oid +" order  products";
	}

}
