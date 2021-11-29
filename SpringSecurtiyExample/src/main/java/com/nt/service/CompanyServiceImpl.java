package com.nt.service;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.nt.model.UserRolesTab;
import com.nt.repo.UserRepo;

@Service
public class CompanyServiceImpl implements ICompanyService,UserDetailsService {
	
	
	@Autowired
	private BCryptPasswordEncoder encode;
	
	@Autowired
	private UserRepo repo;

	@Override
	public int saveObject(UserRolesTab tab) {
		tab.setEpassword(encode.encode(tab.getEpassword()));
		return repo.save(tab).getId();
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		   Optional<UserRolesTab> opt= repo.findByEmail(username);
		   org.springframework.security.core.userdetails.User user=null;
		   if(opt.isEmpty()) {
			   throw new UsernameNotFoundException("user not found by this email"+username);
		   }else {
			   UserRolesTab userrole=opt.get();
		   
		   user=new User(username,userrole.getEpassword() , userrole.getRoles().stream().map(role->new SimpleGrantedAuthority(role)).collect(Collectors.toSet()));
		   }
		return user;
	}

}
