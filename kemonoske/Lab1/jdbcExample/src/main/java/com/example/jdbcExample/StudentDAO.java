package com.example.jdbcExample;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

	private List<Student> students = null;/* Will contain table rows */
	private Connection con = null;

	public StudentDAO() throws ClassNotFoundException, SQLException {

		students = new ArrayList<Student>();
		/*
		 * Use reflection to conect Pastgres 9.1 JDBC4 driver, Not sure if I
		 * really need this
		 */
		Class.forName("org.postgresql.Driver");

		/* Get conection to postgres database using DriverMAnager */
		con = DriverManager
				.getConnection("jdbc:postgresql://localhost:5432/Lab1",
						"postgres", "postgres");

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
	 * HTML format
	 * 
	 * @return
	 */
	/*
	 * public String listStudents() {
	 * 
	 * StringBuilder sb = new StringBuilder(); sb.append("<table>");
	 * sb.append(System.getProperty("line.separator")); sb.append("<tr>");
	 * sb.append(System.getProperty("line.separator")); sb.append("<th>");
	 * sb.append(System.getProperty("line.separator")); sb.append("ID");
	 * sb.append(System.getProperty("line.separator")); sb.append("</th>");
	 * sb.append(System.getProperty("line.separator")); sb.append("<th>");
	 * sb.append(System.getProperty("line.separator")); sb.append("First Name");
	 * sb.append(System.getProperty("line.separator")); sb.append("</th>");
	 * sb.append(System.getProperty("line.separator")); sb.append("<th>");
	 * sb.append(System.getProperty("line.separator")); sb.append("Last Name");
	 * sb.append(System.getProperty("line.separator")); sb.append("</th>");
	 * sb.append(System.getProperty("line.separator")); sb.append("</tr>");
	 * sb.append(System.getProperty("line.separator"));
	 * 
	 * for(Student i : students) {
	 * 
	 * sb.append("<tr>"); sb.append(System.getProperty("line.separator"));
	 * sb.append("<td>"); sb.append(System.getProperty("line.separator"));
	 * sb.append(i.getId()); sb.append(System.getProperty("line.separator"));
	 * sb.append("</td>"); sb.append(System.getProperty("line.separator"));
	 * sb.append("<td>"); sb.append(System.getProperty("line.separator"));
	 * sb.append(i.getFirst_name());
	 * sb.append(System.getProperty("line.separator")); sb.append("</td>");
	 * sb.append(System.getProperty("line.separator")); sb.append("<td>");
	 * sb.append(System.getProperty("line.separator"));
	 * sb.append(i.getLast_name());
	 * sb.append(System.getProperty("line.separator")); sb.append("</td>");
	 * sb.append(System.getProperty("line.separator")); sb.append("</tr>");
	 * 
	 * }
	 * 
	 * sb.append("</table>"); sb.append(System.getProperty("line.separator"));
	 * 
	 * return sb.toString(); }
	 */

	/**
	 * Will close connection and clear list here on class destroy
	 */
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		con.close();
		con = null;
		students.clear();
		students = null;
	}

	public List<Student> listStudents() throws SQLException {
		Statement st = con.createStatement();

		/* Select all rows from Students table */
		ResultSet rs = st.executeQuery("SELECT * FROM \"Students\"");

		/* Add selected rows to Array List */
		while (rs.next())
			students.add(new Student(rs.getInt("id"), rs
					.getString("first_name"), rs.getString("last_name")));
		rs.close();
		return students;
	}

	public Connection getCon() {
		return con;
	}

}
