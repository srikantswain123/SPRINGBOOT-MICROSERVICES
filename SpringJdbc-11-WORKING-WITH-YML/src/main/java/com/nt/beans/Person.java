package com.nt.beans;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@ConfigurationProperties(prefix = "per.info")
public class Person {
	private int pid;
	private String pname;
	private String paddrs;
	private int[] marks;
	private List<Integer> result;
	private Set<Integer> phones;
	private Map<String,Long> banks;
	private Job job;
	

}
