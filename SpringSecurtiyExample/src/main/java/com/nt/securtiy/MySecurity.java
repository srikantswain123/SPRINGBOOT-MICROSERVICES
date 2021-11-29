package com.nt.securtiy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
@EnableWebSecurity
@Configuration
public class MySecurity extends WebSecurityConfigurerAdapter {
	
	
	@Autowired
	private UserDetailsService userDetailsService;
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(encoder);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/home","/Save","/csrfTest").permitAll()
		.antMatchers("/csrfGet").hasAuthority("ADMIN")
		.antMatchers("/employee").hasAuthority("EMPLOYEE")
		.antMatchers("/student").hasAuthority("STUDENT")
		.antMatchers("/admin").hasAuthority("ADMIN")
		.antMatchers("/college").hasAnyAuthority("COLLEGE","ADMIN")
		.anyRequest().authenticated()
		.and()
		.formLogin()
		.defaultSuccessUrl("/home", false)
		.and()
		.logout()
		.logoutRequestMatcher(new AntPathRequestMatcher("/sighnOut"))
		.logoutSuccessUrl("/login")
		.and()
		.exceptionHandling()
		.accessDeniedPage("/denied");
		//http.csrf().disable();
		
	}

}
