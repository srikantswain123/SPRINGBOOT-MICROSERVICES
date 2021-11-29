package com.nt.service;

import java.util.List;

import com.nt.dto.BankAccountDto;

public interface IBankAccountService {
	public List<BankAccountDto> fetchAccountDetailsByBalance(Float minBalance,Float MaxBalance);
	public BankAccountDto fetchBankAccountDetailsByAccoujntNo(Long acno);
	public String addBonusToAccount(Float addBonus,Float balance);

}
