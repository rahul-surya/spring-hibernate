package com.surya.springdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.hibernate.loader.GeneratedCollectionAliases;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CustomerLoggingAspect {
	
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	@Pointcut("execution(* com.surya.springdemo.controller.*.*(..))")
	private void forControllerPkg() {}
	
	@Pointcut("execution(* com.surya.springdemo.service.*.*(..))")
	private void forServicePkg() {}

	@Pointcut("execution(* com.surya.springdemo.dao.*.*(..))")
	private void forDaoPkg() {}
	
	@Pointcut("forControllerPkg() || forServicePkg() || forDaoPkg()")
	private void forAppFlow() {}
	
	
	@Before("forAppFlow()")
	private void before(JoinPoint theJoinPoint) {
		
		String method = theJoinPoint.getSignature().toShortString();
		
		myLogger.info("=====> in @Before: calling method : "+ method);
		
		Object[] args = theJoinPoint.getArgs();
		
		for(Object a : args) {
			
			myLogger.info("======>Argument : "+a);
		}
	}
	
	@AfterReturning(pointcut="forAppFlow()", returning = "result")
	private void AfterReturning(JoinPoint theJoinPoint, Object result) {
		
		String method = theJoinPoint.getSignature().toShortString();
		
		myLogger.info("=====> in @AfterReturning: calling method : "+ method);
		
		myLogger.info("=====> result : "+ result);
		
		
	}
	
	

	

}
