package com.surya.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.surya.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	private List<Student> theStudents ;
	
	@PostConstruct
	public void loadData() {
		
		theStudents = new ArrayList<>();
		
		theStudents.add(new Student("John","Smith"));
		theStudents.add(new Student("Radha","Mishra"));
		theStudents.add(new Student("Mayur","Sah"));
		
	}
	
	//http://localhost:8089/spring-rest-demo/api/students
	@GetMapping("/students")
	public List<Student> getStudents(){
		
		return theStudents;
		
	}
	
	//http://localhost:8089/spring-rest-demo/api/students/1
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		
		if(studentId >= theStudents.size() || studentId < 0) {
			throw new StudentNotFoundException("Student id not found:"+studentId);
		}
		
		return theStudents.get(studentId);
	}
	
	
//	@ExceptionHandler
//	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc){
//		
//		StudentErrorResponse studentRes = new StudentErrorResponse();
//		
//		studentRes.setStatus(HttpStatus.NOT_FOUND.value());
//		studentRes.setMessage(exc.getMessage());
//		studentRes.setTimeStamp(System.currentTimeMillis());
//		
//		return new ResponseEntity<StudentErrorResponse>(studentRes, HttpStatus.NOT_FOUND);
//	}
//	
//	
//	@ExceptionHandler
//	public ResponseEntity<StudentErrorResponse> handleException(Exception exc){
//		
//		StudentErrorResponse studentRes = new StudentErrorResponse();
//		
//		studentRes.setStatus(HttpStatus.BAD_REQUEST.value());
//		studentRes.setMessage(exc.getMessage());
//		studentRes.setTimeStamp(System.currentTimeMillis());
//		
//		return new ResponseEntity<StudentErrorResponse>(studentRes, HttpStatus.BAD_REQUEST);
//	}

}
