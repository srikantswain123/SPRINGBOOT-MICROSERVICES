package com.nt.model;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@ConfigurationProperties(prefix = "emp.info")
public class Employee {
	private int eno;
	private String ename;
	private List<Integer> marks;
	private Set<Integer> phones;
	private Map<String,Integer> accounts;
	private Job job;

}
