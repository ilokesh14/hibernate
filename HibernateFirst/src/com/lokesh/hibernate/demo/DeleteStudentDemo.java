package com.lokesh.hibernate.demo;

import org.hibernate.SessionFactory;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.lokesh.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

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
			List<Student> stdList = session.createQuery("from Student s where s.firstName='Mohan'").getResultList() ;

//			getting the persistance object of student using its ID .
			System.out.println("getting the persistance object of student using its ID .");
			Student student = session.get(Student.class,stdList.get(0).getId());

//			Deleting the student
			System.out.println("Deleting the student");
			session.delete(student);
			
//			Deleting student whose id is 4.
			System.out.println("Deleting student whose id is 4.");
			session.createQuery("delete from Student s where id = 5 ").executeUpdate() ;
			
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
