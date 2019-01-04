package com.lokesh.hibernate.demo;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.lokesh.hibernate.demo.entity.Instructor;
import com.lokesh.hibernate.demo.entity.InstructorDetails;

public class CreateDemo {

	public static void main(String[] args) {
		
		try {
			System.out.println("Starting");
			Instructor instructor = new Instructor() ;
			instructor.setFirstName("robin");
			instructor.setLastName("gautam");
			instructor.setEmail("robin@gmail.com");
			
			System.out.println("Created Instructor object "+instructor);
			
			InstructorDetails instructorDetails = new InstructorDetails() ;
			instructor.setInstructorDetails(instructorDetails);
			instructorDetails.setHobby("teaching");
			instructorDetails.setYoutubeChannel("Provido");
			
			System.out.println("Created InstructorDetails object "+instructorDetails);
			
			System.out.println("before sessionfactory.buildSessionFactory()");
			SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Instructor.class).
											addAnnotatedClass(InstructorDetails.class).buildSessionFactory() ;
			
			System.out.println("before sessionFactory.openSession()");
			Session session = sessionFactory.openSession() ;
			
			System.out.println("before session.beginTransaction()");			
			Transaction transaction = session.beginTransaction();
			
			System.out.println("before session.save(std)");
			session.save(instructor);
			
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
