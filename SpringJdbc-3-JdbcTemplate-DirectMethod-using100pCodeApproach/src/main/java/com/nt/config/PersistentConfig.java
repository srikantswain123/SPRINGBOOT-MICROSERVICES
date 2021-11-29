package com.nt.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan(basePackages = "com.nt.dao")
@PropertySource("com/nt/commons/jdbc.properties")
public class PersistentConfig {
	
	@Autowired
	private Environment env;
	
	@Bean(name="hkDs")
	public HikariDataSource cSource() {
		HikariDataSource ds=null;
		ds=new HikariDataSource();
		ds.setDriverClassName(env.getRequiredProperty("jdbc.class"));
		ds.setJdbcUrl(env.getRequiredProperty("jdbc.url"));
		ds.setUsername(env.getRequiredProperty("jdbc.user"));
		ds.setPassword(env.getRequiredProperty("jdbc.password"));
		ds.setMinimumIdle(Integer.parseInt(env.getRequiredProperty("jdbc.minpool")));
		ds.setMaximumPoolSize(Integer.parseInt(env.getRequiredProperty("jdbc.maxpool")));
		return ds;
	}
	
	@Bean(name="jt")
	public JdbcTemplate jt() {
		return new JdbcTemplate(cSource());
	}
	

}
