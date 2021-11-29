package com.nt.comp;

public class Car {
	private Engine engine;

	public void setEngine(Engine engine) {
		this.engine = engine;
	}
	public String purchae() {
		String msg=null;
		msg=engine.engine();
		return msg;
		
	}

}
