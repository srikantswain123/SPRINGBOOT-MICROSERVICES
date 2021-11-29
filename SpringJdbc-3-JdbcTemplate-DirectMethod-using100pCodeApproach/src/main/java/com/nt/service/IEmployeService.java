package com.nt.service;

import java.util.List;
import java.util.Map;

public interface IEmployeService {
	
	public int fetchEmpCountOfRecord() ;
	public String fetchEmpName(int eno);
	public Map<String,Object> fetchEmpDetails(int eno);
	public List<Map<String,Object>> fetchAllEmpDetails(String desg1,String desg2);
	public String insertEmpDetail(String ename,String job,float sal);
	public String loadBonusByDesg(String desg,float sal);
	public String deleteEmpDetails(int eno);

}
