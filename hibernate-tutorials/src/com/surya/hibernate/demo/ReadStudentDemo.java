package com.surya.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.surya.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public ReadStudentDemo() {
		
	}

	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration()
				                            .configure("hibernate.cfg.xml")
				                            .addAnnotatedClass(Student.class)
				                            .buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		
		try {
			Student student = new Student("Rahul4", "Surya4", "r.surya@gmail.com");
			
			session.beginTransaction();
			
			System.out.println("Saving student object:"+student);
			
			session.save(student);
			
			session.getTransaction().commit();
			
			System.out.println("Saved student generated id:"+student.getId());
			
			session = sessionFactory.getCurrentSession();
			
			session.beginTransaction();
			
			System.out.println("Getting student with id:"+student.getId());
			
			Student myStudent = session.get(Student.class, student.getId());
			
			System.out.println("Read student:"+myStudent);
			
			session.getTransaction().commit();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			sessionFactory.close();
		}

	}

}
