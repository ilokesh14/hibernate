package com.lokesh.hibernate.demo;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.lokesh.hibernate.demo.entity.Instructor;
import com.lokesh.hibernate.demo.entity.InstructorDetails;

public class BidirectionalDemo {

	public static void main(String[] args) {
		
		try {
			
			System.out.println("before sessionfactory.buildSessionFactory()");
			SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Instructor.class).
											addAnnotatedClass(InstructorDetails.class).buildSessionFactory() ;
			
			System.out.println("before sessionFactory.openSession()");
			Session session = sessionFactory.openSession() ;
			
			
			System.out.println("before session.beginTransaction()");			
			Transaction transaction = session.beginTransaction();
			
			int id = 1 ;
			InstructorDetails instructorDetails = session.get(InstructorDetails.class,id);
			
			instructorDetails.getInstructor().setInstructorDetails(null) ;
			
			session.delete(instructorDetails);
			
			
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
