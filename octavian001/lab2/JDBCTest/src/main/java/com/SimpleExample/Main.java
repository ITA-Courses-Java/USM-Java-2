package com.SimpleExample;

public class Main {
	public static void main(String args[]) throws Exception
	{
		StudDAO s1 = new StudDAO();
		s1.listStudents();
		s1.addStud(new Stud("student1","student2"));
		s1.deleteStud(3);
	}

}
