package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nt.bo.CustomerBO;

@Repository("dao")
@Profile({"uat","prod"})
public class OraCustomerDAOImpl implements CustomerDAO {
	private static final String CUSTOMER_REGIST="INSERT INTO CUSTOMER_REGIST VALUES(SEQ_NO.NEXTVAL,?,?,?,?)";
	@Autowired
	private JdbcTemplate jt;

	@Override
	public int insert(CustomerBO bo) throws Exception {
		System.out.println("Oracle ::"+jt.getDataSource().getClass());
        int count=jt.update(CUSTOMER_REGIST, bo.getCname(),bo.getCadd(),bo.getPamt(),bo.getInterset());
		return count;
	}

}
