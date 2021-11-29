package com.nt.beans;

import java.util.Date;
import java.util.Map;

//using Map
public class Employee {
	private Map<Integer,String> empnoname;
	private Map<Date,Date> joindate;
	public void setEmpnoname(Map<Integer, String> empnoname) {
		System.out.println(empnoname.getClass());
		this.empnoname = empnoname;
	}
	public void setJoindate(Map<Date, Date> joindate) {
		this.joindate = joindate;
	}
	@Override
	public String toString() {
		return "Employee [empnoname=" + empnoname + ", joindate=" + joindate + "]";
	}
	
	

}
