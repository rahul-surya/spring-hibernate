package com.surya.springdemo.mvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;



public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String>{

	private String coursePrefix[];
	
	@Override
	public void initialize(CourseCode theCourseCode) {

		coursePrefix = theCourseCode.value();
		
	}

	@Override
	public boolean isValid(String theCourse, ConstraintValidatorContext constraintValidatorContext ) {
		
		boolean result = false;
		
		if(theCourse != null) {
			for(String tempSuffix : coursePrefix) {
				result = theCourse.startsWith(tempSuffix);
				if(result)
					break;
			}
			
		}
		else {
			result = false; 
		}
		
		return result;
		
	}
	
	

}
