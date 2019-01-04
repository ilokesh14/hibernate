package com.lokesh.hibernate.demo;

import org.hibernate.SessionFactory;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.lokesh.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		
		try {
			System.out.println("Starting");

			System.out.println("Created Student object");
			
			System.out.println("before sessionfactory.buildSessionFactory()");
			SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory() ;
			
			System.out.println("before sessionFactory.openSession()");
			Session session = sessionFactory.openSession() ;
			
			System.out.println("before session.beginTransaction()");			
			Transaction transaction = session.beginTransaction();

//			Getting students whose name is Bittu
			System.out.println("Getting students whose name is Bittu");
			List<Student> stdList = session.createQuery("from Student s where s.firstName='Bittu'").getResultList() ;

//			getting the persistance object of student using its ID .
			System.out.println("getting the persistance object of student using its ID .");
			Student student = session.get(Student.class,stdList.get(0).getId());

//			Updating the attributes
			System.out.println("Updating the attributes");
			student.setFirstName("Lokesh");
			
//			Updating emails for all the Student whose lastName is kumar
			System.out.println("Updating emails for all the Student whose lastName is kumar");
			session.createQuery("update Student s set email='yahoo.com' where s.lastName='kumar'").executeUpdate() ;
			
			System.out.println("before session.getTransaction().commit()");
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
