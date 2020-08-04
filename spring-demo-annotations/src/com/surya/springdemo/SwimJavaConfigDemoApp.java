package com.surya.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SwimJavaConfigDemoApp {

	public static void main(String[] args) {


		//read spring java config class
		
//		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
		
		//get the bean from spring container
		
		//Coach  theCoach = context.getBean("tennisCoach",Coach.class); 
		SwimCoach  theCoach = context.getBean("swimCoach",SwimCoach.class);  //method name of @Bean in java config
		
		//call the method of bean
		
		System.out.println(theCoach.getDailyWorkout());
		
		System.out.println(theCoach.getDailyFortune());
		
		System.out.println("email value from prop:"+theCoach.getEmail());
		
		System.out.println("team value from prop:"+theCoach.getTeam());
		
		
		
		//close the context
		
		context.close();

	}

}
