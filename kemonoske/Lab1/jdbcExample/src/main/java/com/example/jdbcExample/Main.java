package com.example.jdbcExample;

import java.sql.SQLException;
import java.util.List;

public class Main {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		
		StudentDAO sd = new StudentDAO();
<<<<<<< HEAD
		sd.listStudents();
=======
		
		List aux = sd.listStudents();
		
>>>>>>> b95268ab46f1c0464f9dd3d47cd15a34e33a71e4
		System.out.println(sd);
		
	}
	
}
