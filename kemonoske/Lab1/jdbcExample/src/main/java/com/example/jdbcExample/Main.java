package com.example.jdbcExample;

import java.sql.SQLException;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		
		StudentDAO sd = new StudentDAO();
		
		System.out.println(sd.listStudents());
		
	}
	
}
