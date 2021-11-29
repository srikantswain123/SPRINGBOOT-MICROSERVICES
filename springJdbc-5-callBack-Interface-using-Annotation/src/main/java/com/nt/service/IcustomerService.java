package com.nt.service;

import java.util.List;

import com.nt.dto.CustomerDto;

public interface IcustomerService {
	
	public CustomerDto fetchCustomerResult(int cid);
	public List<CustomerDto> fetchCustomerResultsByAddrs(String addr1,String adr2,String addr3);
	public List<CustomerDto> fetchCustomerResultsByAddrs1(String addr1,String adr2,String addr3);
}
