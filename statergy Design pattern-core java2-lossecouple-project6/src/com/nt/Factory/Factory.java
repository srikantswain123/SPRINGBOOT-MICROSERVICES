package com.nt.Factory;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import com.nt.comp.BlueDart;
import com.nt.comp.Courier;
import com.nt.comp.DTDC;
import com.nt.comp.Flipkart;

public class Factory {
	private static InputStream is;
	private static Properties pros;
	static {
		try {
			is=new FileInputStream("src/com/nt/common/info.properties");
			pros=new Properties();
			pros.load(is);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static Flipkart getInstance() throws Exception{
		Courier courier=null;
		Flipkart fkt=null;
		courier=(Courier)Class.forName(pros.getProperty("sd.dependent")).newInstance();
		
		fkt=new Flipkart();
		fkt.setCourier(courier);
		return fkt;
		
		
	}

}
