package com.SimpleExample;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;

public class StudDAO {

	ResultSet rs = null;
	PreparedStatement prep = null;
	Connection con = null;
	Statement st = null;

	private List<Stud> s = new ArrayList<Stud>();

	public StudDAO() {

	}

	public void deleteStud(int id) throws Exception {
		Statement st = null;

		try {
			con = ConnectionFactory.ConnectDB();

			st = con.createStatement();

			String query = "DELETE FROM student" +
					                " WHERE id_stud = " + id + ";";

			st.executeUpdate(query);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
			st.close();
		}
	}

	public void listStudents() throws Exception {

		con = ConnectionFactory.ConnectDB();

		String query = "SELECT * FROM student;";

		Stud student = null;
		try {
			st = con.createStatement();
			rs = st.executeQuery(query);

			while (rs.next()) {
				student = new Stud();
				student.set_id(rs.getInt("id_stud"));
				student.set_first_name(rs.getString("first_name"));
				student.set_last_name(rs.getString("last_name"));

				s.add(student);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			st.close();
			rs.close();
			con.close();
		}

		for (Stud i : s) {
			System.out.print(i.get_first_name());
			System.out.println("\t" + i.get_last_name());
		}
	}

	public void addStud(Stud student) throws Exception {
		try {

			con = ConnectionFactory.ConnectDB();

			String query = "INSERT INTO student VALUES (?,?,?) ";

			prep = con.prepareStatement(query);
			prep.setInt(1, student.get_id());
			prep.setString(2, student.get_first_name());
			prep.setString(3, student.get_last_name());

			prep.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			prep.close();
			con.close();
		}
	}
}
