package com.nt.Test;

import com.nt.Factory.Factory;
import com.nt.comp.Flipkart;

public class StrategyTest {

	public static void main(String[] args) throws Exception{
      Flipkart fkt=Factory.getInstance();
      System.out.println(fkt.shopping(new String[] {"rain coat", "umbrela","flutablet"},new float[] {2000,1000,200}));
	}

}
