package com.nt.Test;

import com.nt.comp.Car;
import com.nt.factory.CarFactory;

public class Test {
	public static void main(String[] args)throws Exception {
		Car car=null;
		car=CarFactory.getInstance();
		System.out.println(car.purchae());
		
	}

}
