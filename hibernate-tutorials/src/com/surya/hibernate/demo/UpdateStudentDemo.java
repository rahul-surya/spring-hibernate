package com.surya.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.surya.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public UpdateStudentDemo() {
		
	}

	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration()
				                            .configure("hibernate.cfg.xml")
				                            .addAnnotatedClass(Student.class)
				                            .buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			int studentId = 3 ;
			System.out.println("Getting student with id:"+studentId);
			
			Student myStudent = session.get(Student.class, studentId);
			
			System.out.println("Read student:"+myStudent);
			
			myStudent.setFirstName("Scooby3");
			
			myStudent.setLastName("Dooby3");
									
			session.getTransaction().commit(); //perform update student set email=?, first_name=?, last_name=? where id=?
			
			session = sessionFactory.getCurrentSession();
			
			session.beginTransaction();
			
			session.createQuery("update Student set email='foo@gmail.com'").executeUpdate();
			
			session.getTransaction().commit();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			sessionFactory.close();
		}

	}

}
