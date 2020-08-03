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

public class CreateCourseStudentDemo {

	public CreateCourseStudentDemo() {
		
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
					
			
			Course course = new Course("Pacman-How to score one million points");
			
			session.save(course);
			
			System.out.println("saved course:"+course);
			
			Student student1 = new Student("Payal", "Watammawar","p@gmail.com");
			Student student2 = new Student("Bhaga", "Shinde","b@gmail.com");
			
			course.addStudent(student1);
			course.addStudent(student2);
			
			System.out.println("\nSaving students...");
			
			session.save(student1);
			session.save(student2);
			
			
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
