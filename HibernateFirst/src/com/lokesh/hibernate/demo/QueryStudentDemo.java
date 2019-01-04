package com.lokesh.hibernate.demo;

import org.hibernate.SessionFactory;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.lokesh.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		
		try {
			System.out.println("Starting");
			
			System.out.println("before sessionfactory.buildSessionFactory()");
			SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory() ;
			
			System.out.println("before sessionFactory.openSession()");
			Session session = sessionFactory.openSession() ;
			
			System.out.println("before session.beginTransaction()");			
			Transaction transaction = session.beginTransaction();
			
//			Query All Student
			System.out.println("Query All Student");
			List<Student> studentList = session.createQuery("from Student").getResultList() ;

			display(studentList);

//			Query student whose last name is = kumar
			System.out.println("Query student whose last name is = kumar");
			studentList = session.createQuery("from Student s where s.lastName='kumar'").getResultList() ;			
			
			display(studentList);

//			Query student whose last name is = lal OR first name = lokesh
			System.out.println("Query student whose last name is = lal OR first name is lokesh ");
			studentList = session.createQuery("from Student s where s.lastName='lal' OR s.firstName ='lokesh'").getResultList() ;			
			
			display(studentList);

			
//			Query student using LIKE clause
			System.out.println("Query student where email LIKE '%gmail.com'");
			studentList = session.createQuery("from Student s where s.email LIKE '%gmail.com'").getResultList() ;			
			
			display(studentList);
			
			
			
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

	private static void display(List<Student> studentList) {
		for(Student student:studentList) {
			System.out.println(student);
		}
		System.out.println("\n");
	}
}
