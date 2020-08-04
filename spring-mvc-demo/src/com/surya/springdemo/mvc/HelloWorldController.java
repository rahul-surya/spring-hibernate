package com.surya.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {
	
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	
	@RequestMapping("/processFormTwo")
	public String processFormTwo(HttpServletRequest request, Model model) {
		
		String name = request.getParameter("studentName");
		
		String upperName = name.toUpperCase();
		
		model.addAttribute("uName", upperName);
		
		return "helloworld";
	}
	
	@RequestMapping("/processFormThree")
	public String processFormTwo(@RequestParam("studentName") String name, Model model) {
		
				
		String upperName = name.toUpperCase();
		
		model.addAttribute("uName", upperName);
		
		return "helloworld";
	}

}
