package com.surya.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.surya.hibernate.demo.entity.Course;
import com.surya.hibernate.demo.entity.Instructor;
import com.surya.hibernate.demo.entity.InstructorDetail;
import com.surya.hibernate.demo.entity.Review;

public class CreateCourseReviewDemo {

	public CreateCourseReviewDemo() {
		
	}

	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration()
				                            .configure("hibernate.cfg.xml")
				                            .addAnnotatedClass(Instructor.class)
				                            .addAnnotatedClass(InstructorDetail.class)
				                            .addAnnotatedClass(Course.class)
				                            .addAnnotatedClass(Review.class)
				                            .buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		
		try {
			
						
			session.beginTransaction();
					
			
			Course course = new Course("Pacman-How to score one million points");
			
			course.addReview(new Review("Greate course..."));
			course.addReview(new Review("cool course...."));
			course.addReview(new Review("nice course...."));
			
			System.out.println("course:"+course);
			
			System.out.println("reviews:"+course.getReviews());
			
			
			session.save(course);
			
			
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
