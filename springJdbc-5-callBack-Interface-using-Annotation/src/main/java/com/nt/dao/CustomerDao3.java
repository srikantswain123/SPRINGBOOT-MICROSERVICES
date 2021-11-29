package com.nt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.nt.bo.CustomerBo;
//@Repository("dao")
public class CustomerDao3 implements IcustomerDao {
	private static final String CUSTOMER="SELECT * FROM CUSTOMER WHERE CID=?";
	private static final String LIST_CUSTOMER_QUERY="SELECT * FROM CUSTOMER WHERE CADDR IN(?,?,?) ";
	
	@Autowired
	private JdbcTemplate jt;
	

	@Override
	public CustomerBo getCustomerResult(int cid) {
		CustomerBo bo=new CustomerBo();
		bo=jt.queryForObject(CUSTOMER,new CustomerRowMapper(), cid);
		return bo;
	}
	
	@Override
	public List<CustomerBo> getCustomerResultByAddress(String addr1, String addr2, String addr3) {
	     List<CustomerBo> listBo=null;
	     listBo=jt.query(LIST_CUSTOMER_QUERY, new CustomerResulSet(),addr1,addr2,addr3);
		return listBo;
	}
	
	
	
	//inner class
	private class CustomerRowMapper implements RowMapper<CustomerBo>{
	
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
		
	}

	
	//inner class
	private class CustomerResulSet implements ResultSetExtractor<List<CustomerBo>>{

		@Override
		public List<CustomerBo> extractData(ResultSet rs) throws SQLException, DataAccessException {
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
		
	}//innerclass
	
	
	
	
	
	@Override
	public List<CustomerBo> getCustomerResultByAdreess1(String addr1, String addr2, String addr3) {
		List<CustomerBo> bo=new ArrayList();
		jt.query(LIST_CUSTOMER_QUERY, new CustomerRowCallBack(bo), addr1,addr2,addr3);
		return bo;
	}//method
	
	//inerr class forRowCallBackHandlerInterface
	public class CustomerRowCallBack implements RowCallbackHandler{
	   private List<CustomerBo> listbo;
	   

		public CustomerRowCallBack(List<CustomerBo> bo) {
		this.listbo = bo;
	     }


		@Override
		public void processRow(ResultSet rs) throws SQLException {
			System.out.println("CustomerDao3.CustomerRowCallBack.processRow(-)");
			CustomerBo bo=null;
				bo=new CustomerBo();
				bo.setCId(rs.getInt(1));
				bo.setCName(rs.getString(2));
				bo.setCAddr(rs.getString(3));
				bo.setCDesg(rs.getString(4));
				bo.setCSal(rs.getFloat(5));
				listbo.add(bo);
			}//process row
			
		}//callBackHandler
		
	}//class


