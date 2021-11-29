package com.nt.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class EmployeeDto implements Serializable {
	private Integer empno;
	private String empname;
	private String job;
	private Integer sal;
	

}
