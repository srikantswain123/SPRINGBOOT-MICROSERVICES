package com.nt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.nt.bo.CustomerBo;
//@Repository("dao")
public class CustomerDao2 implements IcustomerDao {
	private static final String CUSTOMER="SELECT * FROM CUSTOMER WHERE CID=?";
	private static final String LIST_CUSTOMER_QUERY="SELECT * FROM CUSTOMER WHERE CADDR IN(?,?,?) ";
	
	@Autowired
	private JdbcTemplate jt;
	

	@Override
	public CustomerBo getCustomerResult(int cid) {
		CustomerBo bo=new CustomerBo();
		bo=jt.queryForObject(CUSTOMER, new RowMapper<CustomerBo>() {//annonymous inner class

			@Override
			public CustomerBo mapRow(ResultSet rs, int rowNum) throws SQLException {
				CustomerBo bo=new CustomerBo();
				bo.setCId(rs.getInt(1));
				bo.setCName(rs.getString(2));
				bo.setCAddr(rs.getString(3));
				bo.setCDesg(rs.getString(4));
				bo.setCSal(rs.getFloat(5));
				return bo;
			}
			
		}, cid);
		return bo;
	}

//annonymous inner class
	@Override
	public List<CustomerBo> getCustomerResultByAddress(String addr1, String addr2, String addr3) {
		
		List<CustomerBo> listBo=jt.query(LIST_CUSTOMER_QUERY, new ResultSetExtractor<List<CustomerBo>>() {

			@Override
			public List<CustomerBo> extractData(ResultSet rs) throws SQLException, DataAccessException {//annonymous inner class
				List<CustomerBo> listBo=null;
				listBo=new ArrayList<CustomerBo>();
				CustomerBo bo=null;
				while(rs.next()) {
					bo=new CustomerBo();
					bo.setCId(rs.getInt(1));
					bo.setCName(rs.getString(2));
					bo.setCAddr(rs.getString(3));
					bo.setCDesg(rs.getString(4));
					bo.setCSal(rs.getFloat(5));
					listBo.add(bo);
				}
				
				return listBo;
			}
			
		}, addr1,addr2,addr3);
		
		return listBo;
	}
	
	//annynomus
	@Override
	public List<CustomerBo> getCustomerResultByAdreess1(String addr1, String addr2, String addr3) {
		List<CustomerBo> listBo=new ArrayList();
		jt.query(LIST_CUSTOMER_QUERY, new RowCallbackHandler() {
			
			@Override
			public void processRow(ResultSet rs) throws SQLException {
			System.out.println("CustomerDao2.getCustomerResultByAdreess1(...).new RowCallbackHandler() {...}.processRow(-)using annynomus");
				CustomerBo bo=new CustomerBo();
				bo.setCId(rs.getInt(1));
				bo.setCName(rs.getString(2));
				bo.setCAddr(rs.getString(3));
				bo.setCDesg(rs.getString(4));
				bo.setCSal(rs.getFloat(5));
				listBo.add(bo);
			}
		}, addr1,addr2,addr3);
		return listBo;
	}//method
	
	
	

}//class
