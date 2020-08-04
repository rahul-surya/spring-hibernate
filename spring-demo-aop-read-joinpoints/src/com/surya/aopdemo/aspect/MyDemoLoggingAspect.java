package com.surya.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.surya.aopdemo.Account;

@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect {
	
	@Before("com.surya.aopdemo.aspect.AspectExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		
		System.out.println("\n=====>> Executing @Before advice on addAccount()  ");
		
		MethodSignature sig = (MethodSignature) theJoinPoint.getSignature();
		
		System.out.println("Method : "+sig);
		
		Object[] args = theJoinPoint.getArgs();
		
		for(Object theArg : args) {
			System.out.println(theArg);
			
			if(theArg instanceof Account) {
				
				Account account = (Account) theArg;
				
				System.out.println("Account NAme:"+account.getName());
				System.out.println("Account Level:"+account.getLevel());
			}
		}
	}
	
	

}
