package com.example.jdbcExample;

import java.sql.SQLException;
import java.util.List;

public class Main {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		
		StudentDAO sd = new StudentDAO();
		
		List aux = sd.listStudents();
		
		System.out.println(sd);
		
	}
	
}
