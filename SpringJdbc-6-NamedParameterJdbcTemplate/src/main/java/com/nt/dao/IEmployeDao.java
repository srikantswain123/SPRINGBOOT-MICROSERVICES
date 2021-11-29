package com.nt.dao;

import java.util.List;

import com.nt.bo.EmployeeBo;

public interface IEmployeDao {
	public String getEmpNameByNo(int empno);
	public List<EmployeeBo> getEmpDetailsByDesg(String desg1,String desg2,String desg3);
	public int insertEmpDetails(EmployeeBo bo);

}
