package com.nt.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.nt.bo.CustomerBo;
//@Repository("dao")
public class CustomerDao1 implements IcustomerDao {
	private static final String CUSTOMER="SELECT * FROM CUSTOMER WHERE CID=?";
	private static final String LIST_CUSTOMER_QUERY="SELECT * FROM CUSTOMER WHERE CADDR IN(?,?,?) ";
	
	@Autowired
	private JdbcTemplate jt;
	

	@Override
	public CustomerBo getCustomerResult(int cid) {
		CustomerBo bo=new CustomerBo();
		bo=jt.queryForObject(CUSTOMER, new BeanPropertyRowMapper<CustomerBo>(CustomerBo.class), cid);
		return bo;
	}


	@Override
	public List<CustomerBo> getCustomerResultByAddress(String addr1, String addr2, String ddr3) {
		BeanPropertyRowMapper<CustomerBo> bprm=null;
		//row Mapper used for copy each record from db columns to bo proprty column and bo property must match
		bprm=new BeanPropertyRowMapper<CustomerBo>(CustomerBo.class);
		//rowMapperResultSetExtractor is implicit method for copy each record from rowMapper to ResultSet as group of object in a single entity as list
		
		return jt.query(LIST_CUSTOMER_QUERY, new RowMapperResultSetExtractor<CustomerBo>(bprm), addr1,addr2,ddr3);
	}
	
	
	@Override
	public List<CustomerBo> getCustomerResultByAdreess1(String addr1, String addr2, String addr3) {
		
		return null;
	}
	
	
	
		
	

}
