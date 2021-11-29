package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.nt.bo.CustomerBO;
import com.nt.dao.CustomerDAO;
import com.nt.dto.CustomerDTO;

@Service("service")
public class CustomerMgmtServiceImpl implements CustomerMgmtService {
	@Autowired
	private CustomerDAO dao;
	
	


	@Override
	public String calculate(CustomerDTO dto) throws Exception {
		float intrest=0;
		intrest=(dto.getPamt()*dto.getRtintrest()*dto.getTime())/100.0f;
		CustomerBO bo=null;
		bo=new CustomerBO();
		bo.setCname(dto.getCname());
		bo.setCadd(dto.getCadd());
		bo.setPamt(dto.getPamt());
		bo.setInterset(intrest);
		int count=dao.insert(bo);
		System.out.println(count);
		return count==0?"registration failed":"registration succeded";
	}

}
