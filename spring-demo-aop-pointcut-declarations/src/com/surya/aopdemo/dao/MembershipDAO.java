package com.surya.aopdemo.dao;

import org.springframework.stereotype.Component;



@Component
public class MembershipDAO {
	
	public void addAccount() {
		
		System.out.println(getClass()+" : DOING MY DB WORK: ADDING AN ACCOUNT");
	}
	
    public void goToSleep() {
		
		System.out.println(getClass()+" : IM GOING TO SLEEP NOW...");
	}


}
