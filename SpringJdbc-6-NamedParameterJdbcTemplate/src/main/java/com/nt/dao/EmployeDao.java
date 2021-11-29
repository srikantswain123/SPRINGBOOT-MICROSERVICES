package com.nt.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nt.bo.EmployeeBo;

@Repository("empDao")
public class EmployeDao implements IEmployeDao {
	private static final String EMP_NAME_BY_NO="SELECT ENAME FROM EMP WHERE EMPNO=:NO";
	private static final String EMP_DETAILS_BY_DESG="SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE JOB IN(:DESG1,:DESG2,:DESG3)";
	//here parmeter must be match with bo class property name and also its case sensitivity
	private static final String INSERT_EMP_DETAILS="INSERT INTO EMP(EMPNO,ENAME,JOB,SAL) VALUES(:empno,:empname,:job,:sal)";
	
	
	@Autowired
	private NamedParameterJdbcTemplate npjt;

	@Override
	public String getEmpNameByNo(int empno) {
		//1st approach using MapObject
		Map<String,Object> paramMap=Map.of("NO",empno);
		String result=npjt.queryForObject(EMP_NAME_BY_NO, paramMap, String.class);
		return result;
	}//method
	
	
	@Override
	public List<EmployeeBo> getEmpDetailsByDesg(String desg1, String desg2, String desg3) {
		//Second approach first implementation class of SqlParameter Source
		MapSqlParameterSource msps=new MapSqlParameterSource();
		//add named Parmeter to Map SqlParameter
		msps.addValue("DESG1", desg1);
		msps.addValue("DESG2", desg2);
		msps.addValue("DESG3", desg3);
		List<EmployeeBo> listBo=npjt.query(EMP_DETAILS_BY_DESG, msps, rs->{
			List<EmployeeBo> listBo1=new ArrayList();
			while(rs.next()) {
				EmployeeBo bo=new EmployeeBo();
				bo.setEmpno(rs.getInt(1));
				bo.setEmpname(rs.getString(2));
				bo.setJob(rs.getString(3));
				bo.setSal(rs.getInt(4));
				listBo1.add(bo);
			}
			return listBo1;
		});
		return listBo;
	}//ResultSetExtractor With Lambda
	
  @Override
public int insertEmpDetails(EmployeeBo bo) {
	BeanPropertySqlParameterSource bpsps=new BeanPropertySqlParameterSource(bo);
	  int count=npjt.update(INSERT_EMP_DETAILS, bpsps);
	  return count;
}

}//class
