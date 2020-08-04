package com.surya.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {


		//read spring config file
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//get the bean from spring container
		
		//Coach  theCoach = context.getBean("tennisCoach",Coach.class); 
		TennisCoach  theCoach = context.getBean("tennisCoach",TennisCoach.class);
		
		//call the method of bean
		
		System.out.println(theCoach.getDailyWorkout());
		
		System.out.println(theCoach.getDailyFortune());
		
		System.out.println("Email from properties:"+theCoach.getEmail());
		
		System.out.println("Team from properties:"+theCoach.getTeam());
		
		
		//close the context
		
		context.close();

	}

}
