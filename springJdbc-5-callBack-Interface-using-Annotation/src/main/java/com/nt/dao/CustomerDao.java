package com.nt.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nt.bo.CustomerBo;
@Repository("dao")
public class CustomerDao implements IcustomerDao {
	private static final String CUSTOMER="SELECT * FROM CUSTOMER WHERE CID=?";
	private static final String LIST_CUSTOMER_QUERY="SELECT * FROM CUSTOMER WHERE CADDR IN(?,?,?) ";
	
	@Autowired
	private JdbcTemplate jt;
	

	@Override
	public CustomerBo getCustomerResult(int cid) {
		CustomerBo bo=new CustomerBo();
		bo=jt.queryForObject(CUSTOMER, (rs,rowNum)->{
			CustomerBo bo1=new CustomerBo();
			bo1.setCId(rs.getInt(1));
			bo1.setCName(rs.getString(2));
			bo1.setCAddr(rs.getString(3));
			bo1.setCDesg(rs.getString(4));
			bo1.setCSal(rs.getFloat(5));
			return bo1;
		}, cid);
		return bo;
	}


	@Override
	public List<CustomerBo> getCustomerResultByAddress(String addr1, String addr2, String ddr3) {
		
		return jt.query(LIST_CUSTOMER_QUERY, (rs)->{
			List<CustomerBo> listBo=new ArrayList();
			while(rs.next()) {
				CustomerBo bo=new CustomerBo();
				bo.setCId(rs.getInt(1));
				bo.setCName(rs.getString(2));
				bo.setCAddr(rs.getString(3));
				bo.setCDesg(rs.getString(4));
				bo.setCSal(rs.getFloat(5));
				listBo.add(bo);
			}
			return listBo;
		},
				addr1,addr2,ddr3);
	}//lambda
	@Override
	public List<CustomerBo> getCustomerResultByAdreess1(String addr1, String addr2, String addr3) {
		List<CustomerBo> listBo=new ArrayList();
		jt.query(LIST_CUSTOMER_QUERY, rs->{
			CustomerBo bo=new CustomerBo();
			System.out.println("CustomerDao.getCustomerResultByAdreess1(-)-using Lambda");
			bo.setCId(rs.getInt(1));
			bo.setCName(rs.getString(2));
			bo.setCAddr(rs.getString(3));
			bo.setCDesg(rs.getString(4));
			bo.setCSal(rs.getFloat(5));
			listBo.add(bo);
			
		}, addr1,addr2,addr3);
		
		return listBo;
	}

}//class
