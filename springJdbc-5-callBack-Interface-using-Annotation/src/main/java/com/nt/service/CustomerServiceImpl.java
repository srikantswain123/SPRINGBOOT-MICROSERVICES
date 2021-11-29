package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.bo.CustomerBo;
import com.nt.dao.IcustomerDao;
import com.nt.dto.CustomerDto;


@Service("service")
public class CustomerServiceImpl implements IcustomerService {
	
	@Autowired
	private IcustomerDao dao;

	@Override
	public CustomerDto fetchCustomerResult(int cid) {
		CustomerBo bo=null;
		CustomerDto dto=new CustomerDto();
		bo=dao.getCustomerResult(cid);
		BeanUtils.copyProperties(bo, dto);
		return dto;
	}
	@Override
	public List<CustomerDto> fetchCustomerResultsByAddrs(String addr1, String addr2, String addr3) {
		List<CustomerBo> listBo=null;
		List<CustomerDto> listDto=new ArrayList();
		
		listBo=dao.getCustomerResultByAddress(addr1, addr2, addr3);
		//convert to listDto
		listBo.forEach(bo->{
			CustomerDto dto=new CustomerDto();
			BeanUtils.copyProperties(bo, dto);
			if(bo.getCDesg().equalsIgnoreCase("ceo"))
				dto.setPositon("President of Company");
			else if(bo.getCDesg().equalsIgnoreCase("ba"))
				dto.setPositon("business Annalysist");
			else if(bo.getCDesg().equalsIgnoreCase("manager"))
				dto.setPositon("Project handler");
			else
				dto.setPositon("Employee");
			dto.setSrno(listDto.size()+1);
			listDto.add(dto);
		});
		return listDto;
	}
	@Override
	public List<CustomerDto> fetchCustomerResultsByAddrs1(String addr1, String addr2, String addr3) {
		List<CustomerBo> listBo=null;
		List<CustomerDto> listDto=new ArrayList();
		
		listBo=dao.getCustomerResultByAdreess1(addr1, addr2, addr3);
		//convert to listDto
		listBo.forEach(bo->{
			CustomerDto dto=new CustomerDto();
			BeanUtils.copyProperties(bo, dto);
			if(bo.getCDesg().equalsIgnoreCase("ceo"))
				dto.setPositon("President of Company");
			else if(bo.getCDesg().equalsIgnoreCase("ba"))
				dto.setPositon("business Annalysist");
			else if(bo.getCDesg().equalsIgnoreCase("manager"))
				dto.setPositon("Project handler");
			else
				dto.setPositon("Employee");
			dto.setSrno(listDto.size()+1);
			listDto.add(dto);
		});
		return listDto;
	}//method

}//class
