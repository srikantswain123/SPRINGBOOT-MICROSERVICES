package com.nt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;
import org.springframework.jdbc.object.SqlUpdate;
import org.springframework.stereotype.Repository;

import com.nt.bo.BankAccountBo;

@Repository("dao")
public class BankAccountDaoImpl implements IBankAccountDao {
	private static final String GETBANKACCOUNTDETAILSBYBALANCE = "SELECT ACNO,HOLDERNAME,BALANCE,STATUS FROM BANK_ACCOUNT WHERE BALANCE>=? AND BALANCE<=?";
	private static final String GETBANKACCOUNTDETAILSBYACNO = "SELECT ACNO,HOLDERNAME,BALANCE,STATUS FROM BANK_ACCOUNT WHERE ACNO=?";
	private static final String UPDATE_BANKACCOUNTBY_BONUS = "UPDATE BANK_ACCOUNT SET BALANCE=BALANCE+? WHERE BALANCE<=?";
	
	BankAccountSelector1 selector1;
	BankAccountSelector2 selector2;
	BankAccountSelector3 selector3;

	@Autowired
	public BankAccountDaoImpl(DataSource ds) {
		//here ds is requierd only for constructor call
		selector1 = new BankAccountSelector1(ds, GETBANKACCOUNTDETAILSBYBALANCE);
		selector2 = new BankAccountSelector2(ds, GETBANKACCOUNTDETAILSBYACNO);
		selector3 = new BankAccountSelector3(ds, UPDATE_BANKACCOUNTBY_BONUS);
	}

	@Override
	public List<BankAccountBo> getAccountByBalance(Float minBalance, Float MaxBalance) {
		//use excute method for entity object it ineternally convert single object to list object
		return selector1.execute(minBalance, MaxBalance);
	}//balance method

	//inner class1
	private class BankAccountSelector1 extends MappingSqlQuery<BankAccountBo> {
		public BankAccountSelector1(DataSource ds, String query) {
			super(ds, query);
			//set ds and query to super class constructor for precompild sql query for  one time
			//must declare requierd parameter type of jdbc data type 
			super.declareParameter(new SqlParameter(Types.FLOAT));
			super.declareParameter(new SqlParameter(Types.FLOAT));
			//pre compile the query
			super.compile();
		}//constructor

		//call back method
		@Override
		public BankAccountBo mapRow(ResultSet rs, int rowNum) throws SQLException {
			//set data to bo object
			BankAccountBo bo = new BankAccountBo();
			bo.setAcno(rs.getLong(1));
			bo.setHolderName(rs.getString(2));
			bo.setBalance(rs.getFloat(3));
			bo.setStatus(rs.getString(4));
			return bo;
		}//callback map row(-,-)
	}//inner class

	@Override
	public BankAccountBo getAccountDeatiByAcno(Long acno) {
		//use Find object method for single record
		return selector2.findObject(acno);
	}//for single record

	//2nd inner class for single record
	private static class BankAccountSelector2 extends MappingSqlQuery<BankAccountBo> {

		public BankAccountSelector2(DataSource ds, String sql) {
			super(ds, sql);
			//register query parameter type
			super.declareParameter(new SqlParameter(Types.INTEGER));
			//compile sql  query
			super.compile();
		}

		@Override
		public BankAccountBo mapRow(ResultSet rs, int rowNum) throws SQLException {
			//bankAcccount object
			BankAccountBo bo = new BankAccountBo();
			bo.setAcno(rs.getLong(1));
			bo.setHolderName(rs.getString(2));
			bo.setBalance(rs.getFloat(3));
			bo.setStatus(rs.getString(4));
			//return bo
			return bo;
		}//map row

	}//inner class
	
	@Override
	public int addBonusToEmploye(Float addBonus, Float balance) {
		//update method with var args type
		return selector3.update(addBonus,balance);
	}//update method
	
	//inner class for update query
	private static class BankAccountSelector3 extends SqlUpdate{

		public BankAccountSelector3(DataSource ds,String sql) {
			super(ds, sql);
			//register query parameter type
			super.declareParameter(new SqlParameter(Types.FLOAT));
			super.declareParameter(new SqlParameter(Types.FLOAT));
			//compile sql  query
			super.compile();
		}//constructor
		

	}//inner class

}//class
