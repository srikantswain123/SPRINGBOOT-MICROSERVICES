package com.nt.comp;

public class Volvo implements Engine {
	

	public Volvo() {
		System.out.println("Volvo cass Using Zero Param Constructor");
		// TODO Auto-generated constructor stub
	}

	@Override
	public String engine() {
		System.out.println("purchase Volvo car");
		return "Volovo car using petrol engine for high comfort";
	}

}
