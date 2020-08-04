package com.surya.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.surya.aopdemo.Account;

@Component
public class AccountDAO {
	
	private String name;
	private String serviceCode;
	
	public List<Account> findAccounts(boolean tripWire){
		
		//for academic purpose....simulate an exception
		if(tripWire) {
			
			throw new RuntimeException("no time for you!!!");
		}
		
		List<Account> accounts = new ArrayList<Account>();
		
		accounts.add(new Account("Akshay", "Gold"));
		accounts.add(new Account("Ajay", "Platinum"));
		accounts.add(new Account("Raj", "Silver"));
		
		return accounts;
		
	}
	
	public void addAccount(Account account,Boolean vipFlag) {
		
		System.out.println(getClass()+" : DOING MY DB WORK: ADDING AN ACCOUNT");
	}

	
    public boolean doWork() { 
 		
		System.out.println(getClass()+" : DOING MY WORK");
		
		return true;
	}


	public String getName() {
		System.out.println(getClass()+" : getName()");
		return name;
	}


	public void setName(String name) {
		System.out.println(getClass()+" : setName()");
		this.name = name;
	}


	public String getServiceCode() {
		System.out.println(getClass()+" : getServiceCode()");
		return serviceCode;
	}


	public void setServiceCode(String serviceCode) {
		System.out.println(getClass()+" : setServiceCode()");
		this.serviceCode = serviceCode;
	}
    
    

}
