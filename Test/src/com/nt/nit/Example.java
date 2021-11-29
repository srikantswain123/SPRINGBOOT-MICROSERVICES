package com.nt.nit;

public class Example {
	public int value;
	public String type;
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Example [value=" + value + ", type=" + type + "]";
	}
	

}
