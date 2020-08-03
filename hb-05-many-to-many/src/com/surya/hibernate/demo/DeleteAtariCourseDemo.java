package com.surya.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.engine.transaction.jta.platform.internal.SynchronizationRegistryBasedSynchronizationStrategy;

import com.surya.hibernate.demo.entity.Course;
import com.surya.hibernate.demo.entity.Instructor;
import com.surya.hibernate.demo.entity.InstructorDetail;
import com.surya.hibernate.demo.entity.Review;
import com.surya.hibernate.demo.entity.Student;

public class DeleteAtariCourseDemo {

	public DeleteAtariCourseDemo() {
		
	}

	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration()
				                            .configure("hibernate.cfg.xml")
				                            .addAnnotatedClass(Instructor.class)
				                            .addAnnotatedClass(InstructorDetail.class)
				                            .addAnnotatedClass(Course.class)
				                            .addAnnotatedClass(Review.class)
				                            .addAnnotatedClass(Student.class)
				                            .buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		
		try {
			
						
			session.beginTransaction();
					
			int theId = 13;
			
			Course course = session.get(Course.class, theId);
			
			System.out.println("Loaded Course:"+course);
			
			System.out.println("Course students:"+course.getStudents());
			
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
