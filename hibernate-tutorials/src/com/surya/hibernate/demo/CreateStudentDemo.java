package com.surya.hibernate.demo;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.surya.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public CreateStudentDemo() {
		
	}

	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration()
				                            .configure("hibernate.cfg.xml")
				                            .addAnnotatedClass(Student.class)
				                            .buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		
		try {
			
		     String theDateOfBirthStr = "31/12/1998";
		     
	         Date theDateOfBirth = DateUtils.parseDate(theDateOfBirthStr);
	         
			Student student = new Student("Sachin", "Surya", "s.surya@gmail.com",theDateOfBirth);
			
			session.beginTransaction();
			
			session.save(student);
			
			session.getTransaction().commit();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			sessionFactory.close();
		}

	}

}
