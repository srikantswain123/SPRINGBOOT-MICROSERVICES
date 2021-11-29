package com.nt.comp;

public class Maruti implements Engine {

	public Maruti() {
		System.out.println("Maruti class Zero param constructor");
	}

	@Override
	public String engine() {
		System.out.println("purchase Maruti car");
		return "Maruti car using Diesel Engine for heavy pickup";
	}

}
