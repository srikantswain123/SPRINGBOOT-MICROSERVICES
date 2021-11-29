package com.nt.beans;

import java.util.Date;
import java.util.Set;

public class University {
	
	private Set<Integer> facultyNo;
	private Set<Date> joinDate;
	public University(Set<Integer> facultyNo, Set<Date> joinDate) {
		System.out.println(facultyNo.getClass());
		this.facultyNo = facultyNo;
		this.joinDate = joinDate;
	}
	@Override
	public String toString() {
		return "University [facultyNo=" + facultyNo + ", joinDate=" + joinDate + "]";
	}
	
	
	

}
