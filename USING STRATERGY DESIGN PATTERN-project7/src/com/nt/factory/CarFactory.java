package com.nt.factory;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import com.nt.comp.Car;
import com.nt.comp.Engine;

public class CarFactory {
	private static InputStream is=null;
	private static Properties pros=null;
	
	static {
		try {
			is=new FileInputStream("src/com/nt/common/info.properties");
			pros=new Properties();
			pros.load(is);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	
	public static Car getInstance()throws Exception{
		Engine engine=null;
		Car car=null;
		engine=(Engine)Class.forName(pros.getProperty("ds.dependent1")).newInstance();
		car=new Car();
		car.setEngine(engine);
		return car;
     		
		
		
		
	}

}
