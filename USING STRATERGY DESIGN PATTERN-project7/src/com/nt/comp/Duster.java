package com.nt.comp;

public class Duster implements Engine {
	

	public Duster() {
		System.out.println("Duster class Zero param constructor");
	}

	@Override
	public String engine() {
		System.out.println("purchase DUster car");
		return "Duster car using Petrol Engine for heavy pickup";
	}

}
