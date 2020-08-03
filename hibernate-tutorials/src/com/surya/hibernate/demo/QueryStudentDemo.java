package com.surya.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.surya.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public QueryStudentDemo() {
		
	}

	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration()
				                            .configure("hibernate.cfg.xml")
				                            .addAnnotatedClass(Student.class)
				                            .buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		
		try {
						
			session.beginTransaction();
			
			List<Student> students = session.createQuery("from Student").getResultList();    //Student is java entity class name
			
			displayStudent(students);
			
			
			students = session.createQuery("from Student s where s.firstName like '%4'").getResultList();
			
			System.out.println("\nStudent who's firstName ends with 4.");
			
			displayStudent(students);
			
			session.getTransaction().commit();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			sessionFactory.close();
		}

	}

	private static void displayStudent(List<Student> students) {
		for(Student s : students) {
			System.out.println(s);
		}
	}

}
