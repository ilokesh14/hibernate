package com.lokesh.hibernate.demo;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.lokesh.hibernate.demo.entity.Course;
import com.lokesh.hibernate.demo.entity.Instructor;
import com.lokesh.hibernate.demo.entity.InstructorDetails;

public class CreateCoursesDemo {

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

			System.out.println("before session.beginTransaction()");			
			Transaction transaction = session.beginTransaction();


			int id = 7 ;
			
			Instructor instructor = session.get(Instructor.class,id) ;
			Course c1 = new Course();
			Course c2 = new Course();
			
			c1.setTitle("Java");
			c2.setTitle("C#");
			
			instructor.add(c1);
			instructor.add(c2);
			
			session.save(c1) ;
			session.save(c2) ;
			
			
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
