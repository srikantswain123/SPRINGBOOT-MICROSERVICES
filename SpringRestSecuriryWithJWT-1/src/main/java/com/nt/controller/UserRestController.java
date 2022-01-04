package com.nt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.model.UserDetails;
import com.nt.model.UserRequest;
import com.nt.model.UserResponse;
import com.nt.service.IUserDetailsService;
import com.nt.utils.JwtUtils;

@RestController
@RequestMapping("/rest")
public class UserRestController {
	
	@Value("${server.port}")
	private String port;
	
	@Autowired
	private IUserDetailsService service;
	@Autowired
	private JwtUtils utils;
	@Autowired
	private AuthenticationManager authenticationManger;
	
	@PostMapping("/save")
	public ResponseEntity<String> saveObject(@RequestBody UserDetails user){
		return ResponseEntity.ok(service.saveUser(user));
	}
	
	//login and generate token
	@PostMapping("/login")
	public ResponseEntity<UserResponse> login(@RequestBody UserRequest reuest){
		
		//validate username and password before generate token
		authenticationManger.authenticate(new UsernamePasswordAuthenticationToken(reuest.getUsername(), reuest.getPwd()));
		
		//generate token
		String generatetoken=utils.generateToken(reuest.getUsername());
		return new ResponseEntity<UserResponse>(new UserResponse(generatetoken,"!sucessfully henerated"),HttpStatus.OK);
		
	}
	
	
	//after token authentication this page wil show
	@GetMapping("/show")
	public ResponseEntity<String > mainPageAfterTokenAuthenticate(){
		return ResponseEntity.ok("prpoerly token authenticate "+port);
	}

}
