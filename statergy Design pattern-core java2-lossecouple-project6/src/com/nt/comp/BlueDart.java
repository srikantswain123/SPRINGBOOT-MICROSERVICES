package com.nt.comp;

public class BlueDart implements Courier {

	@Override
	public String deliver(int oid) {
		
		return "DTDC Courier will deliver  order id :: "+oid +" order  products";
	}

}
