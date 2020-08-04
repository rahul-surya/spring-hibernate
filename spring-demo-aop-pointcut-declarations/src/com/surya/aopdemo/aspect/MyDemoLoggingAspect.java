package com.surya.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	//this is where we add all of our related advices for logging
	
	
	//pointcut expression : execution(modifier-pattern? return-type-pattern declaring-type-pattern?
	//                      method-name-pattern(param-pattern) throws-pattern?)
	
	//The pattern is optional if it has "?"
	//For the pattern, can use wildcard: * (matches on everything)
	
	//For param-pattern : () matches no arg method, (*) matches one arg method of any type and 
	//                    (..) matches 0 or more arg method of any type
	
	
	@Pointcut("execution(* com.surya.aopdemo.dao.*.*(..))")
	private void forDaoPackage() {}
	
//	@Before("execution(public void com.surya.aopdemo.dao.AccountDAO.addAccount())")
//	@Before("execution(public void addAccount())")   // any class addAccount() with return type void
//	@Before("execution(public void add*())")   // any class any method that starts with 'add' with return type void
//	@Before("execution(void add*())")   // any class any method that starts with 'add' with return type void
//	@Before("execution(* add*())")   // any class any method that starts with 'add' with any return type
//	@Before("execution(* add*(com.surya.aopdemo.Account))") // method that starts with add and Account as arg
//	@Before("execution(* add*(com.surya.aopdemo.Account,..))")// method that starts with add and Account as first arg atleast
//	@Before("execution(* add*(..))")// method that starts with add and 0 or more arg of any type
//	@Before("execution(* com.surya.aopdemo.dao.*.*(..))") //any method in dao pkg any class(*), any method(*), any param(..)
	@Before("forDaoPackage()")
	public void beforeAddAccountAdvice() {
		
		System.out.println("\n=====>> Executing @Before advice on addAccount()  ");
	}
	
	@Before("forDaoPackage()")
	public void performApiAnalytics() {
		
		System.out.println("\n=====>> Performing API analytics");
	}
	
	
	

}
