package com.lokesh.hibernate.demo;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.lokesh.hibernate.demo.entity.Course;
import com.lokesh.hibernate.demo.entity.Instructor;
import com.lokesh.hibernate.demo.entity.InstructorDetails;

public class CreateInstructorDemo {

	public static void main(String[] args) {
		
		try {
			System.out.println("Starting");
			
			System.out.println("before sessionfactory.buildSessionFactory()");
			SessionFactory sessionFactory = new Configuration().configure().
											addAnnotatedClass(Instructor.class).
											addAnnotatedClass(InstructorDetails.class).
											addAnnotatedClass(Course.class).
											buildSessionFactory() ;
			
			System.out.println("before sessionFactory.openSession()");
			Session session = sessionFactory.openSession() ;
			
			Instructor instructor = new Instructor() ;
			instructor.setFirstName("lokesh");
			instructor.setLastName("kumar");
			instructor.setEmail("lokesh@gmail.com");
			
			System.out.println("Created Instructor object "+instructor);
			
			
			InstructorDetails instructorDetails = new InstructorDetails() ;
			instructorDetails.setHobby("sport");
			instructorDetails.setYoutubeChannel("youtuber");
			instructor.setInstructorDetails(instructorDetails);
			
			System.out.println("Created InstructorDetails object "+instructorDetails);

			
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
