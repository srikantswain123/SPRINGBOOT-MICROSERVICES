package com.nt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.nt.dto.CustomerDTO;
import com.nt.service.CustomerMgmtService;
import com.nt.service.CustomerMgmtServiceImpl;
import com.nt.vo.CustomerVO;
@Controller("mco")
public class MainControler {
	
	@Autowired
	private CustomerMgmtServiceImpl service;
	



	public String register(CustomerVO vo)throws Exception {

		CustomerDTO dto=null;
		String result=null;
		dto=new CustomerDTO();
		dto.setCname(vo.getCname());
		dto.setCadd(vo.getCadd());
		dto.setPamt(Float.parseFloat(vo.getPamt()));
		dto.setRtintrest(Float.parseFloat(vo.getRtintrest()));
		dto.setTime(Integer.parseInt(vo.getTime()));
		result=service.calculate(dto);
		return result;
	}

}
