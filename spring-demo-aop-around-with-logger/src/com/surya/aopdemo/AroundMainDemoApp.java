package com.surya.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.surya.aopdemo.dao.AccountDAO;
import com.surya.aopdemo.service.TrafficFortuneService;

public class AroundMainDemoApp {

	public static void main(String[] args) {


		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		TrafficFortuneService trafficFortuneService = context.getBean("trafficFortuneService",TrafficFortuneService.class);
		
		System.out.println("Calling getFortune() in main program");
		
		System.out.println("My fortune is : "+trafficFortuneService.getFortune());
		
		System.out.println("Finished");
		
		context.close();

	}

}
