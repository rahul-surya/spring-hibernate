package com.surya.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope("prototype")      //singleton|prototype|request|session
public class TennisCoach implements Coach {
	
	//Field injection
	@Autowired
	//Required if we have multiple implementations of FortuneService 
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;
	
	
	//load value from properties file
	@Value("${foo.email}")
	private String email;
	
	@Value("${foo.team}")
	private String team;
	
	
	//constructor injection
    /*@Autowired
	public TennisCoach(	@Qualifier("randomFortuneService") FortuneService fortuneService) {
		super();
		this.fortuneService = fortuneService;
	}*/


	@PostConstruct
	public void doInitStuff() {
		System.out.println("doInitStuff called...");
	}
	
	@PreDestroy
	public void doCleanupStuff() {
		System.out.println("doCleanupStuff called....");
	}

	public String getEmail() {
		return email;
	}


	public String getTeam() {
		return team;
	}


	@Override
	public String getDailyWorkout() {

      return "Practice your backhand volley";

	}


	//setter injection
  /*  @Autowired
	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}*/


	//method injection
    /*@Autowired
	public void anyMethodName(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
		System.out.println("Inside anyMethodName()...");
	}*/
	

	@Override
	public String getDailyFortune() {

       return fortuneService.getFortune();
	}

}
