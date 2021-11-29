package com.nt.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.bo.BankAccountBo;
import com.nt.dao.IBankAccountDao;
import com.nt.dto.BankAccountDto;
@Service("bankService")
public class BankAccountServiceImpl implements IBankAccountService {
	
	@Autowired
	private IBankAccountDao dao;

	@Override
	public String registerAccount(BankAccountDto dto) {
		BankAccountBo bo=new BankAccountBo();
		BeanUtils.copyProperties(dto,bo);
		int count=dao.CreateAccount(bo);
		return count!=0?"Registration Suceeded":"Registration Failed";
	}

}
