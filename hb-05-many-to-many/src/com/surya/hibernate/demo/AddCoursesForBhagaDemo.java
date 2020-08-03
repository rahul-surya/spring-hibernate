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

public class AddCoursesForBhagaDemo {

	public AddCoursesForBhagaDemo() {
		
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
					
			int theId = 2;
			
			Student student = session.get(Student.class, theId);
			
			System.out.println("Loaded Student:"+student);
			
			System.out.println("Student course:"+student.getCourses());
			
			Course course1 = new Course("Rubik's Cube - How to speed cube");
			Course course2 = new Course("Atari 2600 - Game developemnt");
			
			course1.addStudent(student);
			course2.addStudent(student);
			
			System.out.println("\nSaving courses...");
			
			session.save(course1);
			session.save(course2);
			
			
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
