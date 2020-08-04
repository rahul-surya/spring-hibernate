package com.surya.aopdemo.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.weaver.tools.cache.GeneratedCachedClassHandler;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.surya.aopdemo.Account;

@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect {
	
	
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	//executes @Before and @After 
	@Around("execution(* com.surya.aopdemo.service.*.getFortune(..))")
	public Object aroundFindAccountAdvice(ProceedingJoinPoint theJointPoint) throws Throwable {
		
		String methodName = theJointPoint.getSignature().toShortString();
		myLogger.info("\n=====> Executing @Around on method : "+methodName);
		
		long startTime = System.currentTimeMillis();
		
		//execute getFortuneMethod() method
		Object result = null;
		
		try {
			result = theJointPoint.proceed();
		} catch (Exception e) {
			
			//log the exception
			myLogger.warning(e.getMessage());
			
			//give user a custom message
			result = "Major accident! But no worries....";
			
			//rethrow exception
			//throw e;
 
		}
		
		long endTime = System.currentTimeMillis();
		
		myLogger.info("\n====> Duration : "+ (endTime-startTime)/1000.0 +" seconds");
		
		return result;
	}
	
	
	//executes before @AfterThrowing or @AfterReturning
	@After("execution(* com.surya.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountAdvice(JoinPoint theJointPoint) {
		
		String methodName = theJointPoint.getSignature().toShortString();
		
		myLogger.info("\n====> executing @After (finally) advice on method: "+ methodName);
		
	}
	
	@AfterThrowing(pointcut="execution(* com.surya.aopdemo.dao.AccountDAO.findAccounts(..))",
			throwing="theExc")
	public void afterThrowingFindAccountAdvice(JoinPoint theJointPoint,Throwable theExc) {
		
		String methodName = theJointPoint.getSignature().toShortString();
		
		myLogger.info("\n====> executing @AfterThrowing advice on method: "+ methodName);
		
		myLogger.info("\n====> The Exception is : "+ theExc);
	}
	
	//Calling program will get modified result
	@AfterReturning(pointcut="execution(* com.surya.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning="result")
	public void afterReturningFindAccountAdvice(JoinPoint theJointPoint,List<Account> result) {
		
		String methodName = theJointPoint.getSignature().toShortString();
		
		myLogger.info("\n===> executing @AfterReturning advice.....on method: "+ methodName);
		
		myLogger.info(" Account List from : "+methodName + " : "+result);
		
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
