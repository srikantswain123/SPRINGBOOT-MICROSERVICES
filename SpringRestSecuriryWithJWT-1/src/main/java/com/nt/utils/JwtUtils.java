package com.nt.utils;

import java.util.Base64;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
@Component
public class JwtUtils {
	
	@Value("${secret.key}")
	private String secrete;
	@Value("${secret.issuer}")
	private String issuer;
	
	//generate token
	public String generateToken(String subject) {
		
		return Jwts.builder()
				.setSubject(subject)
				.setIssuer(issuer)
				.signWith(SignatureAlgorithm.HS256, Base64.getEncoder().encode(secrete.getBytes()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis()+TimeUnit.MINUTES.toMillis(10))).compact();
	}
	
	public Claims getClaims(String token) {
		return Jwts.parser().setSigningKey(Base64.getEncoder().encode(secrete.getBytes()))
		.parseClaimsJws(token).getBody();
	}
	
	public String getSubject(String token) {
	   return getClaims(token).getSubject();	
	}
	
	public Date getExpiryDate(String token) {
		return getClaims(token).getExpiration();
	}
	
	public boolean isTokenExpierd(String token) {
		return getExpiryDate(token).before(new Date(System.currentTimeMillis()));
	}
	
	public boolean validateToken(String username,String token) {
		String getUserName=getSubject(token);
		return (getUserName.equals(username)&& !isTokenExpierd(token));
	}

}
