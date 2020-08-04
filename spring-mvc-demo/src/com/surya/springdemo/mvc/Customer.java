package com.surya.springdemo.mvc;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.surya.springdemo.mvc.validation.CourseCode;

public class Customer {
	
	private String firstName;
	
	@NotNull(message = "is mandatory.")      //display if empty or all whitespace because of InitBinder in controller
	@Size(min = 1, message = "is required.")
	private String lastName;
	
	@NotNull(message = "is mandatory.")
	@Min(value = 0 , message = "must be greater than or equal to zero.")
	@Max(value = 10 , message = "must be less than or equal to 10.")
	private Integer freePasses;
	
	@Pattern(regexp = "^[a-zA-Z0-9]{6}", message = "only 6 chars/digits")
	private String postalCode;
	
	
	//custom validation
	@CourseCode(value = {"SURYA","RAH"}, message = "must start with SURYA or RAH")
	private String courseCode;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getFreePasses() {
		return freePasses;
	}

	public void setFreePasses(Integer freePasses) {
		this.freePasses = freePasses;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	
	

}
