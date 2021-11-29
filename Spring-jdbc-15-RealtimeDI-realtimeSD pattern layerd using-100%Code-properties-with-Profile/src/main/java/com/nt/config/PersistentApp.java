package com.nt.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan(basePackages = "com.nt.dao")
@PropertySource(value = "com/nt/commons/application.properties")
public class PersistentApp {
	@Autowired
	private DataSource ds;
	@Bean
	@Profile({"dev","test"})
	//test
	public DataSource createApacheDBCPDataSource()throws Exception {
		System.out.println("dev----test");
		BasicDataSource bds=new BasicDataSource();
		bds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		bds.setUrl("jdbc:mysql:///ntsp713");
		bds.setUsername("root");
		bds.setPassword("root");
		this.ds=bds;
		return ds;
	}
	
	@Bean
	@Profile("uat")
	//uat
	public DataSource createC3p0DataSource()throws Exception {
		System.out.println("uat");
		ComboPooledDataSource cds=new ComboPooledDataSource();
		cds.setDriverClass("oracle.jdbc.driver.OracleDriver");
		cds.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:orcl");
		cds.setUser("system");
		cds.setPassword("Srikant1234");
		this.ds=cds;
		return ds;
	}
	@Bean
	@Profile("prod")
	//production
	public DataSource createHikariDataSource() {
		System.out.println("prod");
		HikariDataSource hkds=new HikariDataSource();
		hkds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		hkds.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:orcl");
		hkds.setUsername("system");
		hkds.setPassword("Srikant1234");
		this.ds=hkds;
		return ds;
	}
	
	@Bean
	@Profile({"dev","test","uat","prod"})
	public JdbcTemplate createJdbcTemplates() {
		return new JdbcTemplate(ds);
	}
	
	

}
