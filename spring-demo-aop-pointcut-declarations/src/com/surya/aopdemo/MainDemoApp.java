package com.surya.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.surya.aopdemo.dao.AccountDAO;
import com.surya.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {


		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		AccountDAO accountDAO = context.getBean("accountDAO",AccountDAO.class);
		
		Account account = new Account();
		
		accountDAO.addAccount(account,true);
		
		accountDAO.doWork();
		
       MembershipDAO membershipDAO = context.getBean("membershipDAO",MembershipDAO.class);
		
       membershipDAO.addAccount();
       
       membershipDAO.goToSleep();
		
		context.close();

	}

}
