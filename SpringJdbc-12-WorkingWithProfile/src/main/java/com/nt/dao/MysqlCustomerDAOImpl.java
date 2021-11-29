package com.nt.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nt.bo.CustomerBO;

@Profile({"test","dev"})
@Repository("MysqlCustDao")
public class MysqlCustomerDAOImpl implements CustomerDAO {

	private static final String CUSTOMER_REGIST="INSERT INTO CUSTOMER_REGIST(CNAME,CADD,PAMT,INTREST) VALUES(?,?,?,?)";
	@Autowired
	private JdbcTemplate jt;

	@Override
	public int insert(CustomerBO bo) throws Exception {
		System.out.println("Mysql CiustomerDao datasource::"+jt.getDataSource());
		int count=jt.update(CUSTOMER_REGIST, bo.getCname(),bo.getCadd(),bo.getPamt(),bo.getInterset());
		return count;
	}

}
