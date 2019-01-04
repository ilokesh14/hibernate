package com.lokesh.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false" ;
		String user = "root" ;
		String password = "Lokesh@1411" ;
		try {
			System.out.println("Connection to database "+url);
			Connection connection = DriverManager.getConnection(url,user,password) ;
			
			System.out.println("Connection Successful ");
			connection.close();
		}
		catch(Exception e ) {
			System.out.println("Exception "+e);
		}
	}
}
