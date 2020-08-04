package com.surya.aopdemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.surya.aopdemo.service.TrafficFortuneService;

public class AroundWithLoggerMainDemoApp {

	private static Logger myLogger = Logger.getLogger(AroundWithLoggerMainDemoApp.class.getName());
	
	public static void main(String[] args) {


		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		TrafficFortuneService trafficFortuneService = context.getBean("trafficFortuneService",TrafficFortuneService.class);
		
		myLogger.info("Calling getFortune() in main program");
		
		myLogger.info("My fortune is : "+trafficFortuneService.getFortune());
		
		myLogger.info("Finished");
		
		context.close();

	}

}
