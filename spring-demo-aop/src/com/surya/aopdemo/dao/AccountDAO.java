package com.surya.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.surya.aopdemo.Account;

@Component
public class AccountDAO {
	
	public void addAccount(Account account,Boolean vipFlag) {
		
		System.out.println(getClass()+" : DOING MY DB WORK: ADDING AN ACCOUNT");
	}

	
    public boolean doWork() { 
 		
		System.out.println(getClass()+" : DOING MY WORK");
		
		return true;
	}

}
