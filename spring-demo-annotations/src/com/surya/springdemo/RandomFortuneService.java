package com.surya.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	private String[] data = {
	   "Beware","Diligence","Journey"		
	};
	
	private Random myRandom = new Random();
	
	@Override
	public String getFortune() {
		//pick random string from the array
		
		int index = myRandom.nextInt(data.length);
		
		return data[index];

	}

}
