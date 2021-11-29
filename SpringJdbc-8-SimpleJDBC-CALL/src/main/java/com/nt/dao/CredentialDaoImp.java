package com.nt.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

@Repository("dao")
public class CredentialDaoImp implements ICredentialDao {
	
	@Autowired
	private SimpleJdbcCall sjc;

	@Override
	public String credential(String uname, String pwd) {
		
		sjc.setProcedureName("P_AUTHENTICATION");
		Map<String,?> map=Map.of("username",uname,"password",pwd);
		Map<String, ?> result=sjc.execute(map);
		return result.get("RESULT").toString();
	}

}
