package com.surya.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.surya.aopdemo.Account;

@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect {
	
	@AfterThrowing(pointcut="execution(* com.surya.aopdemo.dao.AccountDAO.findAccounts(..))",
			throwing="theExc")
	public void afterThrowingFindAccountAdvice(JoinPoint theJointPoint,Throwable theExc) {
		
		String methodName = theJointPoint.getSignature().toShortString();
		
		System.out.println("\n====> executing @AfterThrowing advice on method: "+ methodName);
		
		System.out.println("\n====> The Exception is : "+ theExc);
		
		
		
		
		
	}
	
	//Calling program will get modified result
	@AfterReturning(pointcut="execution(* com.surya.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning="result")
	public void afterReturningFindAccountAdvice(JoinPoint theJointPoint,List<Account> result) {
		
		String methodName = theJointPoint.getSignature().toShortString();
		
		System.out.println("\n===> executing @AfterReturning advice.....on method: "+ methodName);
		
		System.out.println(" Account List from : "+methodName + " : "+result);
		
		//perform post-processing data task...
		
		convertAccountNamesToUpperCase(result);
		
		
		
	}

	private void convertAccountNamesToUpperCase(List<Account> result) {
		
		for(Account theAccount : result) {
			String name = theAccount.getName();
			theAccount.setName(name.toUpperCase());
		}

		
	}
	
	

}
