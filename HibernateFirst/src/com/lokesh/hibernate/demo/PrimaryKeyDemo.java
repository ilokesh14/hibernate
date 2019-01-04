package com.lokesh.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.lokesh.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		
		
		try {
			System.out.println("Starting");
			Student std1 = new Student("Robin", "Kumar","Robin@gmail.com") ;
			Student std2 = new Student("Varun", "Kumar","Varun@gmail.com") ;
			Student std3 = new Student("Ram", "Kumar","Ram@gmail.com") ;
			
			System.out.println("Created 3 Student object");
			
			System.out.println("before sessionfactory.buildSessionFactory()");
			SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory() ;
			
			System.out.println("before sessionFactory.openSession()");
			Session session = sessionFactory.openSession() ;
			
			System.out.println("before session.beginTransaction()");			
			Transaction transaction = session.beginTransaction();
			
			System.out.println("before session.save(std)");
			session.save(std1);
			session.save(std2);
			session.save(std3);
			
			System.out.println("brfore session.getTransaction().commit()");
			transaction.commit();
			
			System.out.println("before session.close()");
			session.close();
			
			System.out.println("Done ... ");

		}
		catch(Exception e) {
			System.out.println("exception occurred  "+e);
		}

		
	}
}
