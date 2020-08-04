package com.luv2code.springdemo;

public class TrackCoach implements Coach{
	
	private FortuneService fortuneService;
	
	
	//define a constructor for dependency injection
	public TrackCoach(FortuneService fortuneService) {
		super();
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		
		return "Run a hard 5k";
		
	}

	@Override
	public String getDailyFortune() {
		
		return fortuneService.getFortune();

	}
	
	//add init method
	public void myInitMethod() {
		System.out.println("do startup task...");
	}
	
	//add destroy method
		public void myDestroyMethod() {
			System.out.println("do cleanup task...");
		}

}
