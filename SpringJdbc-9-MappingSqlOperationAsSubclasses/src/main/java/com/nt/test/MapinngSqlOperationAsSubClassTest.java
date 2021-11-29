package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nt.service.IBankAccountService;

public class MapinngSqlOperationAsSubClassTest {

	public static void main(String[] args) {
        ApplicationContext ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
        IBankAccountService service=ctx.getBean("service",IBankAccountService.class);
        try {
        	System.out.println("BankAccountDetails by balnanc>40000 <1000000");
        	service.fetchAccountDetailsByBalance(40000f, 100000f).forEach(System.out::println);
        }//try
        catch(DataAccessException dae) {
        	dae.printStackTrace();
        }//catch
        System.out.println("-----------------------");
        System.out.println("BankAccount Deatils by acno");
        try {
        	System.out.println(service.fetchBankAccountDetailsByAccoujntNo(71878l));
        	
        }catch(DataAccessException dae) {
        	dae.printStackTrace();
        }//catch
        System.out.println("-------------------------");
        try {
        	System.out.println(service.addBonusToAccount(1000f,10000f));
        	
        }catch(DataAccessException dae) {
        	dae.printStackTrace();
        }//catch
        
       ((AbstractApplicationContext) ctx).close();
	}//main

}//class
