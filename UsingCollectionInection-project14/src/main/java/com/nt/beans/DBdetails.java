package com.nt.beans;

import java.util.Properties;

public class DBdetails {
	private Properties classname;
	private Properties usename;
	private Properties password;
	public DBdetails(Properties classname, Properties usename, Properties password) {
		System.out.println(classname.getClass());
		this.classname = classname;
		this.usename = usename;
		this.password = password;
	}
	@Override
	public String toString() {
		return "DBdetails [classname=" + classname + ", usename=" + usename + ", password=" + password + "]";
	}
	
	
	
	

}
