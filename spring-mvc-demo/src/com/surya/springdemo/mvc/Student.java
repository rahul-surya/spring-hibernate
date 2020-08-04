package com.surya.springdemo.mvc;

import java.util.LinkedHashMap;

public class Student {
	
	private String fName;
	private String lName;
	private String country;
	private String pCountry;
	private String favLanguage;
	private String[] operatingSystems;
	
	
	private LinkedHashMap<String,String> countryOptions;
	private LinkedHashMap<String,String> favLanguageOptions;
	
	public Student() {
		countryOptions = new LinkedHashMap<String,String>();
		countryOptions.put("BR", "Brazil");
		countryOptions.put("IN", "India");
		countryOptions.put("FR", "France");
		countryOptions.put("DE", "Germany");
		
		favLanguageOptions = new LinkedHashMap<String,String>();
		favLanguageOptions.put("C++", "C++");
		favLanguageOptions.put("JAVA", "JAVA");
		favLanguageOptions.put("Rubby", "Ruby");
		
	}
	
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

	public LinkedHashMap<String, String> getCountryOptions() {
		return countryOptions;
	}
	
	public String getpCountry() {
		return pCountry;
	}

	public void setpCountry(String pCountry) {
		this.pCountry = pCountry;
	}

	public String getFavLanguage() {
		return favLanguage;
	}

	public void setFavLanguage(String favLanguage) {
		this.favLanguage = favLanguage;
	}

	public LinkedHashMap<String, String> getFavLanguageOptions() {
		return favLanguageOptions;
	}

	public String[] getOperatingSystems() {
		return operatingSystems;
	}

	public void setOperatingSystems(String[] operatingSystems) {
		this.operatingSystems = operatingSystems;
	}



	
	

}
