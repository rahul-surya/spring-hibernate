package com.surya.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.surya.hibernate.demo.entity.Course;
import com.surya.hibernate.demo.entity.Instructor;
import com.surya.hibernate.demo.entity.InstructorDetail;

public class DeleteCourseDemo {

	public DeleteCourseDemo() {
		
	}

	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration()
				                            .configure("hibernate.cfg.xml")
				                            .addAnnotatedClass(Instructor.class)
				                            .addAnnotatedClass(InstructorDetail.class)
				                            .addAnnotatedClass(Course.class)
				                            .buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		
		try {
			
			int id = 10;
			
			session.beginTransaction();
			
			Course course = session.get(Course.class, id);
			
			System.out.println("Deleting course:"+course);
			
			session.delete(course);
			
			session.getTransaction().commit();
			
			System.out.println("Done!!");
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
			sessionFactory.close();
		}

	}

}
