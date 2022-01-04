package com.nt.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.model.UserDetails;
public interface UserRepository extends JpaRepository<UserDetails, Integer> {
	
	public Optional<UserDetails> findByUsername(String username);

}
