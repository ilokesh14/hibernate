package com.lokesh.hibernate.demo;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.lokesh.hibernate.demo.entity.Course;
import com.lokesh.hibernate.demo.entity.Instructor;
import com.lokesh.hibernate.demo.entity.InstructorDetails;
import com.lokesh.hibernate.demo.entity.Review;
import com.lokesh.hibernate.demo.entity.Student;

public class GetCoursesAndStudentsDemo {

	public static void main(String[] args) {
		
		try {
			System.out.println("Starting");
			
			System.out.println("before sessionfactory.buildSessionFactory()");
			SessionFactory sessionFactory = new Configuration().configure().
											addAnnotatedClass(Instructor.class).
											addAnnotatedClass(InstructorDetails.class).
											addAnnotatedClass(Course.class).
											addAnnotatedClass(Review.class).
											addAnnotatedClass(Student.class).
											buildSessionFactory() ;
			
			System.out.println("before sessionFactory.openSession()");
			Session session = sessionFactory.openSession() ;

			System.out.println("before session.beginTransaction()");			
			Transaction transaction = session.beginTransaction();

			int id = 2 ;
			Student student = session.get(Student.class, id) ;
			
			System.out.println("Getting Student "+student+" and Course are "+student.getCourses());
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
