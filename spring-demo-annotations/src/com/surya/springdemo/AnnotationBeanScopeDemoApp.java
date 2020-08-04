package com.surya.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

	public static void main(String[] args) {
		
		       //read spring config file
		
				ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
				
				//get the bean from spring container
				
				 
				Coach  theCoach = context.getBean("tennisCoach",Coach.class);
				
				Coach  alphaCoach = context.getBean("tennisCoach",Coach.class);
				
				//call the method of bean
				
				System.out.println("Pointing to the same object: "+(theCoach==alphaCoach));
				
				System.out.println("Memory location of theCoach: "+theCoach);
				
				System.out.println("Memory location of alphaCoach: "+alphaCoach);
				
				
				
				
				//close the context
				
				context.close();

	}

}
