package com.nt.service;

import java.util.List;
import java.util.Map;

import com.nt.dao.IEmployeDao;

public class EmployeMgmtService implements IEmployeService {
	private IEmployeDao dao;
	

	public EmployeMgmtService(IEmployeDao dao) {
		this.dao = dao;
	}


	@Override
	public int fetchEmpCountOfRecord() {
		// TODO Auto-generated method stub
		return dao.getEmpCount();
	}
	@Override
	public String fetchEmpName(int eno) {
		// TODO Auto-generated method stub
		return dao.getEmpName(eno);
	}
	@Override
	public Map<String, Object> fetchEmpDetails(int eno) {
		// TODO Auto-generated method stub
		return dao.getEmpDetails(eno);
	}
	@Override
	public List<Map<String, Object>> fetchAllEmpDetails(String desg1, String desg2) {
		// TODO Auto-generated method stub
		return dao.getAllEmpDetails(desg1, desg2);
	}
	@Override
	public String insertEmpDetail(String ename, String job, float sal) {
		// TODO Auto-generated method stub
		return dao.insertOperation(ename, job, sal)==0?"Employe registration failed":"Employe Registration Succeded";
	}
	@Override
	public String loadBonusByDesg(String desg,float sal) {
		// TODO Auto-generated method stub
		int count=0;
		count=dao.updateBonusByDesg(desg,sal);
		return count==0?"no record available for modification":count+" details are updated";
	}
	@Override
	public String deleteEmpDetails(int eno) {
		// TODO Auto-generated method stub
		int count=0;
		count= dao.deleteRecordByEmpno(eno);
		return count==0?"no record founds for delete":count+" record deleted";
	}

}
