package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.nt.beans.Person;

@SpringBootApplication
public class SpringJdbc11WorkingWithYmlApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(SpringJdbc11WorkingWithYmlApplication.class, args);
		Person per=ctx.getBean(Person.class);
		System.out.println(per);
	}

}
