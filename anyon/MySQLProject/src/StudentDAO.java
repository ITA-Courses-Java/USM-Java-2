//import java.awt.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;


public class StudentDAO {
	Student student;
	Connection con;
	ResultSet rs;
	Statement st;
	PreparedStatement prep;
	private List<Student> str = new ArrayList<Student>();
	public StudentDAO() throws Exception {		
		Class.forName("com.mysql.jdbc.Driver");
		
		con = DriverManager.getConnection("jdbc:mysql://localhost/test","root","test");
		st = (Statement) con.createStatement();
		rs = st.executeQuery("Select * from student;");
		
	while(rs.next())
	{
		student = new Student();
		//System.out.print(rs.getInt("id_student"));
		student.set_id_student(rs.getInt("id_student"));
		//System.out.print("|"+rs.getString("first_name"));
		student.set_first_name(rs.getString("first_name"));
		//System.out.println("|"+rs.getString("last_name"));
		student.set_last_name(rs.getString("last_name"));
		
		str.add(student);		
	}
		rs.close();
		con.close();
	}
	public  List<Student> listStudents(){
		
		return str;
	}
}
