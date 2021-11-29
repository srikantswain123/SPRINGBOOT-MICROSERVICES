package com.nt.service;

import java.util.List;

import com.nt.dto.EmployeeDto;

public interface IEmployeService {
	public String fetchEmployeNameByNo(int empno);
	public List<EmployeeDto> fetchEmployeDataByDesg(String desg1,String Desg2,String Desg3);
    public String InsertRecordIntoEmployee(EmployeeDto dto); 
}
