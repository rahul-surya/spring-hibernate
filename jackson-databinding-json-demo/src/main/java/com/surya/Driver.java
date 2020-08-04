package com.surya;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {

	public static void main(String[] args) {
		

      ObjectMapper mapper = new ObjectMapper();
      
      try {
		
    	  Student theStudent = mapper.readValue(new File("data/sample-full.json"), Student.class);
		
    	  System.out.println("First Name:"+theStudent.getFirstName());
    	  
    	  Address address = theStudent.getAddress();
    	  
    	  System.out.println("street:"+address.getStreet());
    	  
    	  for(String lang : theStudent.getLanguages()) {
    		  
    		  System.out.println(lang);
    	  }
		
		
	} catch (JsonParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (JsonMappingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
      
      

	}

}
