package com.nt.service;

import java.util.Optional;

import com.nt.model.UserDetails;

public interface IUserDetailsService {
	
	public String saveUser(UserDetails user);
	public Optional<UserDetails> findByUsername(String username);

}
