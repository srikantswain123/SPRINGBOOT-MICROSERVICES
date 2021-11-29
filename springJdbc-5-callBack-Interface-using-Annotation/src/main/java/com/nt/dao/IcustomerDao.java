package com.nt.dao;

import java.util.List;

import com.nt.bo.CustomerBo;

public interface IcustomerDao {
	public CustomerBo getCustomerResult(int cid);
	public List<CustomerBo> getCustomerResultByAddress(String addr1,String addr2,String ddr3); 
	public List<CustomerBo> getCustomerResultByAdreess1(String addr1,String addr2,String addr3);

}
