package com.example.jdbcExample;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class Main {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		
		StudentDAO sd = new StudentDAO();
		sd.addStudent(new Student("Test1", "Test2"));
		LinkedList<Student> aux = sd.listStudents();
		sd.deleteStudent(aux.getLast().getId());
		System.out.println(sd);
		
	}
	
}
