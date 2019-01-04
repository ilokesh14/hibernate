package com.lokesh.hibernate.demo;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.lokesh.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		
		try {
			
			System.out.println("Starting");
			Student std = new Student("Mohan", "Lal","Mohan@gmail.com") ;
			System.out.println("Created Student object");
			
			System.out.println("before sessionfactory.buildSessionFactory()");
			SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory() ;
			
			System.out.println("before sessionFactory.openSession()");
			Session session = sessionFactory.openSession() ;
			
			System.out.println("before session.beginTransaction()");			
			Transaction transaction = session.beginTransaction();
			
			System.out.println("before session.save(std)");
			session.save(std);
			
			System.out.println("brfore session.getTransaction().commit()");
			transaction.commit();
			
			System.out.println("before session.close()");
			session.close();
			
			System.out.println(std);
			System.out.println("Done ... ");

//			Reterival code
			System.out.println("Saved student generated id "+std.getId());
			
		}
		catch(Exception e) {
			System.out.println("exception occurred  "+e);
		}
	}
}
