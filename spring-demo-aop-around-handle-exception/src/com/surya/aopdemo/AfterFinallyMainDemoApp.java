package com.surya.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.surya.aopdemo.dao.AccountDAO;

public class AfterFinallyMainDemoApp {

	public static void main(String[] args) {


		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		AccountDAO accountDAO = context.getBean("accountDAO",AccountDAO.class);
		
		List<Account> accounts = null;
		
		try {
			
			//boolean flag to simulate exception
			boolean tripWire = false;
			
			accounts = accountDAO.findAccounts(tripWire);
		}
		catch(Exception e) {
			System.out.println("\n=====>Main program....  caught exception: "+e);
		}
		
		System.out.println("\n======>Account List from AfterReturningMainDemoApp() :"+accounts);
		
		context.close();

	}

}
