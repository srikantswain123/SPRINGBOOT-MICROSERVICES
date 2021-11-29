package com.nt.controller;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.beansCsrf.CSRF;

public interface UserCsrf extends JpaRepository<CSRF, Integer> {

}
