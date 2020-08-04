package com.surya.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.surya.aopdemo.dao.AccountDAO;

public class AfterReturningMainDemoApp {

	public static void main(String[] args) {


		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		AccountDAO accountDAO = context.getBean("accountDAO",AccountDAO.class);
		
		List<Account> accounts = accountDAO.findAccounts();
		
		System.out.println("\n======>Account List from AfterReturningMainDemoApp() :"+accounts);
		
		context.close();

	}

}
