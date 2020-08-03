package com.surya.hibernate.demo;

import javax.persistence.CascadeType;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.surya.hibernate.demo.entity.Instructor;
import com.surya.hibernate.demo.entity.InstructorDetail;

public class DeleteInstructorDetailDemo {

	public DeleteInstructorDetailDemo() {
		
	}

	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration()
				                            .configure("hibernate.cfg.xml")
				                            .addAnnotatedClass(Instructor.class)
				                            .addAnnotatedClass(InstructorDetail.class)
				                            .buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		
		try {
			
			int tempId = 3;
			
			session.beginTransaction();
			
			InstructorDetail instructorDetail = session.get(InstructorDetail.class, tempId);
			
			System.out.println("InstructorDetail:"+instructorDetail);
			
			if(instructorDetail != null)
			 System.out.println("Asociated Instructor:"+instructorDetail.getInstructor());
			
			//This will also delete instructor object because of CascadeType.ALL
			//session.delete(instructorDetail);
			
			
			//remove the associated object reference to break bi-directional link
			instructorDetail.getInstructor().setInstructorDetail(null);
			
			//This will delete only instructor detail object because of {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH}
			session.delete(instructorDetail);
						
			session.getTransaction().commit();
			
			System.out.println("Done!!");
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			//handle connection leak issue if any exception occures 
			session.close();
			
			sessionFactory.close();
		}

	}

}
