package com.nt.dao;

import java.util.List;
import java.util.Map;

public interface IEmployeDao {
	
	public int  getEmpCount();
	public String getEmpName(int eno);
	public Map<String,Object> getEmpDetails(int eno);
	public List<Map<String,Object>> getAllEmpDetails(String desg1,String desg2);
	public int insertOperation(String ename,String job,float sal);
	public int updateBonusByDesg(String desg,float sal);
	public int deleteRecordByEmpno(int eno);

}
