package com.surya.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.surya.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public PrimaryKeyDemo() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration()
				                .configure("hibernate.cfg.xml")
				                .addAnnotatedClass(Student.class)
				                .buildSessionFactory();
				
				Session session = sessionFactory.getCurrentSession();
				
				try {
				Student student1 = new Student("Rahul1", "Surya1", "r.surya@gmail.com");
				
				Student student2 = new Student("Rahul2", "Surya2", "r.surya@gmail.com");
				
				Student student3 = new Student("Rahul3", "Surya3", "r.surya@gmail.com");
				
				session.beginTransaction();
				
				session.save(student1);
				
				session.save(student2);
				
				session.save(student3);
				
				session.getTransaction().commit();
				
				}catch(Exception e) {
				e.printStackTrace();
				}
				finally {
				sessionFactory.close();
				}

	}

}
