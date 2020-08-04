package com.luv2code.springdemo;

import java.nio.charset.StandardCharsets;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {
		
		        //Load the spring configuration file
				ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");
				
				//retrieve bean class from spring container
				Coach theCoach = context.getBean("myCoach", Coach.class);
				
				Coach alphaCoach = context.getBean("myCoach", Coach.class);
				
				//check pointing to same object
				System.out.println("theCoach==aplhaCoach:"+(theCoach == alphaCoach));
				
				System.out.println("Memory for theCoach:"+theCoach);
				System.out.println("Memory for alphaCoach:"+alphaCoach);
				
				
				
				//close the context
				context.close();

	}

}
