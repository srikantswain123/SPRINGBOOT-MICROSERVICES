package com.nt.fillter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.nt.utils.JwtUtils;
@Component
public class SecurityFillter extends OncePerRequestFilter {
	@Autowired
	private JwtUtils utils;

	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String getTokenFromRequestHeader=request.getHeader("Authorization");
		//check token is null or not
		if(getTokenFromRequestHeader!=null) {
			//get username from token
			String username=utils.getSubject(getTokenFromRequestHeader);
			if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null) {
				
				//after username found from token validate from database using userDetails service 
				UserDetails user=userDetailsService.loadUserByUsername(username);
				
				//if user found by name then validate token using JWT utils class
				boolean isvalid=utils.validateToken(user.getUsername(), getTokenFromRequestHeader);
				
				if(isvalid) {
					//if validate store usernamePassordAuthenticationToken
					
					UsernamePasswordAuthenticationToken authToken=
							new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword(),user.getAuthorities());
					
					//set authentication for current request details
					authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
					
					//previously security context holder is null set user name password authentication  in security contetext holder
					SecurityContextHolder.getContext().setAuthentication(authToken);
				}//is valid

			}//valid username && security context holder

		}  
		filterChain.doFilter(request, response);


	}

}
