package com.nt.dao;

import java.util.List;

import com.nt.bo.BankAccountBo;

public interface IBankAccountDao {
	public List<BankAccountBo> getAccountByBalance(Float minBalance,Float MaxBalance);
	public BankAccountBo getAccountDeatiByAcno(Long acno);
	public int addBonusToEmploye(Float addBonus,Float Balance);

}
