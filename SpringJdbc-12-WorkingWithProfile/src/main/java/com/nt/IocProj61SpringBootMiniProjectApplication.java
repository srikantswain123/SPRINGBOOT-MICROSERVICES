package com.nt;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.nt.controller.MainControler;
import com.nt.vo.CustomerVO;

@SpringBootApplication
public class IocProj61SpringBootMiniProjectApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		ctx=SpringApplication.run(IocProj61SpringBootMiniProjectApplication.class, args);
		Scanner scn=null;
		//create scanner object
		scn=new Scanner(System.in);
		CustomerVO vo=null;
		vo=new CustomerVO();
		System.out.println("Enter customer Name");
		vo.setCname(scn.nextLine());
		
		System.out.println("Enter customer Address");
		vo.setCadd(scn.nextLine());
		System.out.println("Enter Principle Amount");
		vo.setPamt(scn.nextLine());
		System.out.println("Enter Rate of intrest");
		vo.setRtintrest(scn.nextLine());
		System.out.println("Enter year");
		vo.setTime(scn.nextLine());
		MainControler controler=ctx.getBean("mco",MainControler.class);
		//invoke business method
		try {
		System.out.println(controler.register(vo));
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
