package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.bo.BankAccountBo;
import com.nt.dao.IBankAccountDao;
import com.nt.dto.BankAccountDto;

@Service("service")
public class BankAccountServiceImpl implements IBankAccountService {

	@Autowired
	private IBankAccountDao dao;

	@Override
	public List<BankAccountDto> fetchAccountDetailsByBalance(Float minBalance, Float MaxBalance) {
		//invoke dao method
		List<BankAccountBo> listBo = dao.getAccountByBalance(minBalance, MaxBalance);
		List<BankAccountDto> listDto = new ArrayList();
		listBo.forEach(bo -> {
			BankAccountDto dto = new BankAccountDto();
			//copy bo data dto
			BeanUtils.copyProperties(bo, dto);
			listDto.add(dto);
		});
		return listDto;
	}//method

	@Override
	public BankAccountDto fetchBankAccountDetailsByAccoujntNo(Long acno) {
		//invoke dao method
		BankAccountBo bo = dao.getAccountDeatiByAcno(acno);
		BankAccountDto dto = new BankAccountDto();
		//copy record bo to dto
		BeanUtils.copyProperties(bo, dto);
		return dto;
	}//method

	@Override
	public String addBonusToAccount(Float addBonus, Float balance) {
		int count = dao.addBonusToEmploye(addBonus, balance);
		return count + " bonus add to employe Account";
	}//update account balance with bonus
}//class
