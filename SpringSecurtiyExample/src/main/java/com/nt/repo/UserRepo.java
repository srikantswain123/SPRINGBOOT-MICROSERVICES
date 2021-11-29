package com.nt.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.model.UserRolesTab;

public interface UserRepo extends JpaRepository<UserRolesTab, Integer> {
	
	public Optional<UserRolesTab> findByEmail(String Email);

}
