package com.example.jdbcExample;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class StudentDAO {

	private LinkedList<Student> students = null;/* Will contain table rows */
	private ConnectionPool cp = null;

	public StudentDAO() throws ClassNotFoundException {

		students = new LinkedList<Student>();

		try {
			cp = new ConnectionPool("216.218.192.170", 5432, "akira_Lab1",
					"akira_test", "Test_12");
		} catch (NullPointerException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 
	 * @return a table formated string with Students table contents
	 */
	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();

		sb.append("_____________________________________________");
		sb.append(System.getProperty("line.separator"));
		sb.append("|      ID     |  First Name  |   Last Name  |");
		sb.append(System.getProperty("line.separator"));
		sb.append("_____________________________________________");
		sb.append(System.getProperty("line.separator"));

		String a = new String();
		for (Student i : students) {
			sb.append("|" + String.format("%13d", i.getId()) + "|"
					+ String.format("%14s", i.getFirst_name()) + "|"
					+ String.format("%14s", i.getLast_name()) + "|");
			sb.append(System.getProperty("line.separator"));
			sb.append("_____________________________________________");
			sb.append(System.getProperty("line.separator"));
		}

		return sb.toString();

	}

	/**
	 * Will clear ConnectionPool and clear array list on class destroy
	 */
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		cp = null;
		students.clear();
		students = null;
	}

	/**
	 * Reads rows from table and stores information in an ArrayList
	 * 
	 * @return List that contains table rows
	 */
	public LinkedList<Student> listStudents() {

		/* Get a connection from the pool and create statement */
		try (Statement st = cp.connect().createStatement()) {/*
															 * try with
															 * resources will
															 * close st
															 * automaticaly
															 */

			/* Select all rows from Students table */
			try (ResultSet rs = st.executeQuery("SELECT * FROM \"Students\"")) {/*
																				 * try
																				 * with
																				 * resources
																				 * will
																				 * close
																				 * rs
																				 * automaticaly
																				 */

				/* Add selected rows to Array List */
				while (rs.next())
					students.add(new Student(rs.getInt("id"), rs
							.getString("first_name"), rs.getString("last_name")));
				return students;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * Adds a student to List and table
	 * 
	 * @param s
	 *            student that should be added
	 * @return returns added student
	 */
	public Student addStudent(Student s) {

		try (Statement st = cp.connect().createStatement()) {/*
															 * try with
															 * resources will
															 * close st
															 * automaticaly
															 */

			try (ResultSet id = st
					.executeQuery("INSERT INTO \"Students\" (id, first_name, last_name) VALUES (nextval('student_id'), '"
							+ s.getFirst_name()
							+ "', '"
							+ s.getLast_name()
							+ "') RETURNING id")) {
				{/*
				 * try with resources will close id automaticaly
				 */
					id.next();
					s.setId(id.getInt("id"));
					students.add(s);

				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
			return s;

		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return s;

	}

	public void deleteStudent(int id) {

		try (Statement st = cp.connect().createStatement()) {/*
															 * try with
															 * resources will
															 * close st
															 * automaticaly
															 */
															
			if( 1 == st.executeUpdate("DELETE FROM \"Students\" WHERE id = '" + id + "'")) {
				
				for(Student i : students)
					if(i.getId() == id)	{
						students.remove(i);
						break;
					}
				
			}
			

		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
