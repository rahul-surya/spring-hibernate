package com.surya.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.surya.hibernate.demo.entity.Course;
import com.surya.hibernate.demo.entity.Instructor;
import com.surya.hibernate.demo.entity.InstructorDetail;

public class FetchJoinDemo {

	public FetchJoinDemo() {
		
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
			
			int id = 1;
			
			session.beginTransaction();
			
			Query<Instructor> query = session.createQuery("select i from Instructor i "
														+"JOIN FETCH i.courses "
														+"where i.id=:theId",Instructor.class);
			
			query.setParameter("theId", id);
			
			Instructor instructor = query.getSingleResult();
			
//			Instructor instructor = session.get(Instructor.class, id);
			
			System.out.println("Instructor:"+instructor);
			
			session.getTransaction().commit();
			
			session.close();
			
			System.out.println("Courses:"+instructor.getCourses());  //got course after closing session bcz of HQL JOIN FETCH.Another option is use getCourse() before closing session
						
			
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
