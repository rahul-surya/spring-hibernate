package com.surya.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.surya.hibernate.demo.entity.Instructor;
import com.surya.hibernate.demo.entity.InstructorDetail;

public class CreateDemo {

	public CreateDemo() {
		
	}

	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration()
				                            .configure("hibernate.cfg.xml")
				                            .addAnnotatedClass(Instructor.class)
				                            .addAnnotatedClass(InstructorDetail.class)
				                            .buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		
		try {
			
//		    Instructor  instructor = new Instructor("Sachin", "Sharma", "sachin@gmail.com");
//		    
//		    InstructorDetail instructorDetail = new InstructorDetail("http://www.youtube.com","Love to code!!!");
			
            Instructor  instructor = new Instructor("Virat", "Kohli", "virat@gmail.com");
		    
		    InstructorDetail instructorDetail = new InstructorDetail("http://www.youtube.com","Love to code!!!");
		    
		    instructor.setInstructorDetail(instructorDetail);
			
			session.beginTransaction();
			
			System.out.println("Saving instructor:"+instructor);
			
			//This will also save instructor detail object because of CascadeType.ALL
			
			session.save(instructor);
			
			
			session.getTransaction().commit();
			
			System.out.println("Done!!");
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			sessionFactory.close();
		}

	}

}
