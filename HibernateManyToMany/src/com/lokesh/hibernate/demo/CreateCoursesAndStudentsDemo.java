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

public class CreateCoursesAndStudentsDemo {

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

			Course course1 = new Course() ;
			course1.setTitle("Course 1 *** \n");

			Course course2 = new Course() ;
			course2.setTitle("Course 2 **** \n");

			Course course3 = new Course() ;
			course3.setTitle("Course 2 ***** \n");

			
			Student lokesh = new Student();
			lokesh.setFirstName("lokesh");
			lokesh.setLastName("kumar");
			lokesh.setEmail("lokesh@gmail.com");

			Student robin = new Student();
			robin.setFirstName("robin");
			robin.setLastName("gautam");
			robin.setEmail("robin@gmail.com");

			course1.addStudent(lokesh);
			course1.addStudent(robin);
			course2.addStudent(lokesh);
			course2.addStudent(robin);
			course3.addStudent(lokesh);
			
			System.out.println("Saving courses "+course1+" "+course2+" "+course3);
			session.save(course1);
			session.save(course2);
			session.save(course3);
			System.out.println("Saved Courses ");
			
			
			System.out.println("Saving Students "+lokesh+" "+robin);
			session.save(lokesh);
			session.save(robin);
			System.out.println("Saved Students ");
			
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
