package com.nt.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.nt.bo.BankAccountBo;
@Repository("bankDao")
public class BankAccountDaoImpl implements IBankAccountDao {
	@Autowired
	private SimpleJdbcInsert sji;

	
	
	//1st Approach
	/*@Override
	public int CreateAccount(BankAccountBo bo) {
		Map<String,?> map=Map.of("acno",bo.getAcno(),"holdername",bo.getHoldername(),"balance",bo.getBalance(),"status",bo.getStatus());
		sji.setTableName("BANK_ACCOUNT");
		int count=sji.execute(map);
		return count;
	}*/
	
	//2nd Approach
	/*@Override
	public int CreateAccount(BankAccountBo bo) {
		MapSqlParameterSource msps=new MapSqlParameterSource();
		msps.addValue("acno", bo.getAcno());
		msps.addValue("holdername", bo.getHoldername());
		msps.addValue("balance", bo.getBalance());
		msps.addValue("status", bo.getStatus());
		sji.setTableName("BANK_ACCOUNT");
		int count=sji.execute(msps);
		return count;
	}*/
	
	//3rd Approach
	@Override
	public int CreateAccount(BankAccountBo bo) {
		BeanPropertySqlParameterSource bpsp=new BeanPropertySqlParameterSource(bo);
		sji.setTableName("BANK_ACCOUNT");
		int count=sji.execute(bpsp);
		return count;
	}

}
