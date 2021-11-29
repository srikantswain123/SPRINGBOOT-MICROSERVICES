package com.nt.comp;

import java.util.Arrays;
import java.util.Random;

public class Flipkart {
	private Courier courier;

	public void setCourier(Courier courier) {
		this.courier = courier;
	}
	public String shopping(String items[],float amt[]) {
		float billAmt=0.0f;
		int oid=0;
		String msg=null;
		for(float amount:amt)
			billAmt+=amount;
		oid=new Random().nextInt(10000);
		msg=courier.deliver(oid);
		return Arrays.toString(items)+" are purchased having price "+Arrays.toString(amt)+" With billAmount "+billAmt+"--"+msg;
	}
	

}
