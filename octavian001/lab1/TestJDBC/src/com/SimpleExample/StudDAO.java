package com.SimpleExample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
//import java.sql.*;
import java.sql.Statement;
public class StudDAO {
	Connection con;
	ResultSet rs;
	PreparedStatement prep;
	 private List<Stud> s = new ArrayList<Stud>();
	public StudDAO() throws Exception {
        Stud student = null;
		Class.forName("com.mysql.jdbc.Driver");
		//calea catre DB
		String url = "jdbc:mysql://localhost/testing";
		String username = "root";
		String password = "qwerty";
		//conectarea la DB
		Connection conn = DriverManager.getConnection(url, username, password);
		Statement st = conn.createStatement();
		//selectez toate cimpurile
		String query = "SELECT * FROM student";
		ResultSet rs = st.executeQuery(query);
       while(rs.next()){
    	   student = new Stud();
    	   student.set_id(rs.getInt("id_stud"));
    	   student.set_first_name(rs.getString("first_name"));
    	   student.set_last_name(rs.getString("last_name"));
    	   
    	   s.add(student);
       } 
		rs.close();
		conn.close();
	}
	public  List<Stud> listStudents(){
		return s;
	}
	}
