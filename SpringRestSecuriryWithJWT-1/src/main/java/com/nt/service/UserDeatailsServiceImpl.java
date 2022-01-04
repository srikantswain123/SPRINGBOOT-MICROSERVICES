package com.nt.service;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.nt.model.UserDetails;
import com.nt.repo.UserRepository;
@Service
public class UserDeatailsServiceImpl implements IUserDetailsService,UserDetailsService {
	@Autowired
	private  UserRepository repo;
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	
	@Override
	public String saveUser(UserDetails user) {
		user.setPasswd(encoder.encode(user.getPasswd()));
		return repo.save(user).getId()+" registerd";
	}
	
	@Override
	public Optional<UserDetails> findByUsername(String username) {
		// TODO Auto-generated method stub
		return repo.findByUsername(username);
	}
	
	
	@Override
	public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user=null;
		Optional<UserDetails> userdetails=findByUsername(username);
		if(!userdetails.isPresent()) {
			throw new UsernameNotFoundException(username+" not exist");
		}else {
			UserDetails details=userdetails.get();
			user=new User(details.getUsername(), details.getPasswd(),
					details.getRoles().stream().map(role->new SimpleGrantedAuthority(role)).collect(Collectors.toSet()));
		}
		return user;
	}

}
