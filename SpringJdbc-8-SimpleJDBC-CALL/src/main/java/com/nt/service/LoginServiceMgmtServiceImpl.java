package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dao.ICredentialDao;

@Service("service")
public class LoginServiceMgmtServiceImpl implements ILoginServiceMgmt {
	
	@Autowired
	private ICredentialDao dao;

	@Override
	public String loginValidator(String user, String pwd) {
		
		return dao.credential(user, pwd);
	}

}
