package com.lokesh.hibernate.demo;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.lokesh.hibernate.demo.entity.Instructor;
import com.lokesh.hibernate.demo.entity.InstructorDetails;

public class DeleteDemo {

	public static void main(String[] args) {
		
		try {
			
			System.out.println("Starting");
			
			System.out.println("before sessionfactory.buildSessionFactory()");
			SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Instructor.class).
											addAnnotatedClass(InstructorDetails.class).buildSessionFactory() ;
			
			System.out.println("before sessionFactory.openSession()");
			Session session = sessionFactory.openSession() ;

			int id = 2 ;
			
			Instructor instructor = session.get(Instructor.class, id) ;
			System.out.println("found "+instructor);
			
			if(instructor != null) {
				System.out.println("deleting "+instructor+" and instructorDetails");
				session.delete(instructor);
			}
			
			System.out.println("before session.beginTransaction()");			
			Transaction transaction = session.beginTransaction();
			
			System.out.println("before session.save(std)");

			
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
