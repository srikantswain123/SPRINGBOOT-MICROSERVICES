package com.nt.dao;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

public class EmployeDaoImpl implements IEmployeDao {
	private static final String EMP_QUERY="SELECT COUNT(*) FROM EMP";
	private static final String EMP_NAME="SELECT ENAME FROM EMP WHERE EMPNO=?";
	private static final String EMP_DETAILS="SELECT * FROM EMP WHERE EMPNO=?";
	private static final String ALL_EMP_DETAILS="SELECT * FROM EMP WHERE JOB in(?,?)";
	private static final String INSERT_EMP_DETAILS="INSERT INTO EMP(EMPNO,ENAME,JOB,SAL)VALUES(ENO_SEQ.NEXTVAL,?,?,?)";
	private static final String UPDATE_BONUS_BY_DESG="UPDATE EMP SET SAL=SAL+? WHERE JOB=?";
	private static final String DELETE_EMP_DETAILS="DELETE FROM EMP WHERE EMPNO=?";
	
	
	
	
	private JdbcTemplate jt;
	public EmployeDaoImpl(JdbcTemplate jt) {
		this.jt = jt;
	}


	@Override
	public int getEmpCount() {
		int count=jt.queryForObject(EMP_QUERY, Integer.class);
		return count;
	}
	@Override
	public String getEmpName(int eno) {
		// TODO Auto-generated method stub
		return jt.queryForObject(EMP_NAME, String.class, eno);
	}
	@Override
	public Map<String, Object> getEmpDetails(int eno) {
		// TODO Auto-generated method stub
		return jt.queryForMap(EMP_DETAILS, eno);
	}
	@Override
	public List<Map<String, Object>> getAllEmpDetails(String desg1,String desg2) {
		// TODO Auto-generated method stub
		return jt.queryForList(ALL_EMP_DETAILS,desg1,desg2);
	}
	@Override
	public int insertOperation(String ename, String job, float sal) {
		// TODO Auto-generated method stub
		return jt.update(INSERT_EMP_DETAILS,ename,job,sal);
	}
	@Override
	public int updateBonusByDesg(String desg,float sal) {
		// TODO Auto-generated method stub
		return jt.update(UPDATE_BONUS_BY_DESG,sal,desg);
	}
	@Override
	public int deleteRecordByEmpno(int eno) {
		// TODO Auto-generated method stub
		return jt.update(DELETE_EMP_DETAILS, eno);
	}

}
