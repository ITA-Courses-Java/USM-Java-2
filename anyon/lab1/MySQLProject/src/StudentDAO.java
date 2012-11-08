//import java.awt.List;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;


public class StudentDAO {
	/////////////////////////initialisation of the variabiles/////////////////////////////////
	Student student;
	public Connection con;
	public ResultSet rs;
	Statement st;
	public PreparedStatement prep;
	String str;
	int nr;
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	public String first_name,last_name;
	public int id_student;
	private List<Student> lst = new ArrayList<Student>();
	public StudentDAO() throws Exception {		
		Class.forName("com.mysql.jdbc.Driver");

///////////////////////////////////give connection parameters//////////////////////////////////////////////////
		String url = "jdbc:mysql://localhost/test";
		String username = "root";
		String password = "test";
/////////////////////////////////////connect to database//////////////////////////////////////////////////////		
		try{con = DriverManager.getConnection(url, username, password);
		st = (Statement) con.createStatement();
		rs = st.executeQuery("Select * from student;");
///////////////////////////////////////read elements from the table /////////////////////////////
	while(rs.next())
	{
		student = new Student();
		//System.out.print(rs.getInt("id_student"));
		student.set_id_student(rs.getInt("id_student"));
		//System.out.print("|"+rs.getString("first_name"));
		student.set_first_name(rs.getString("first_name"));
		//System.out.println("|"+rs.getString("last_name"));
		student.set_last_name(rs.getString("last_name"));
		
		lst.add(student);		
	}}finally{
	////////////////////////////////close result set and connection//////////////////////////////////////
		rs.close();
		con.close();}
	}
	//////////////////////////////////method that shows the list of students/////////////////////////////
	public  List<Student> listStudents(){
		System.out.println("id\t|first name\t|last name\t|\n");
		for (Student i : lst)
		{System.out.println(i.get_id_student()+"\t|"+i.get_first_name()+"\t|"+i.get_last_name()+"\t|");}			
		return lst;
		}
	//////////////////////////////////////method that adds a student to database//////////////////////////
	public String addStudent(StudentDAO student2) throws SQLException
	{
		String url = "jdbc:mysql://localhost/test";
		String username = "root";
		String password = "test";
		con = DriverManager.getConnection(url, username, password);
		/////////////////////////////////////read variables////////////////////////////////////////
		System.out.println("introduct the number of students you want to add :");
		try{str = bf.readLine();
		nr=(Integer.decode(str)).intValue();
		}catch(IOException ex){};
		
		try{for(int i=0;i<nr;i++){
			if (nr==0)break;
		System.out.println("first_name : ");
		first_name = bf.readLine();
		System.out.println("last name : ");
		last_name = bf.readLine();
				
		for(Student i1 : lst)
		{
		if(id_student < i1.get_id_student())
			id_student = 1+i1.get_id_student();
		}
		////////////////////////////////////insert variables into table////////////////////////////////
		prep=con.prepareStatement("insert into student values(?,?,?);");
		prep.setInt(1, id_student);
		prep.setString(2, first_name);
		prep.setString(3, last_name);
		prep.addBatch();
		
		con.setAutoCommit(false);
		prep.executeBatch();
		con.setAutoCommit(true);
		
		
		}}catch(IOException ex){}
		/////////////////////////////////////////////closing using finally/////////////////////////////
		finally {
			if(con != null)
		con.close();
			if(prep != null)
		prep.close();};
		
		
				
		return first_name;		
	}
	//////////////////////////////////////method to delete variables from database////////////////////////
	public void deleteStudent(int id) throws SQLException
	{		
		String url = "jdbc:mysql://localhost/test";
		String username = "root";
		String password = "test";
		con = DriverManager.getConnection(url, username, password);
		st = (Statement) con.createStatement();
		
		int number = 0;
		st.executeUpdate("delete from student where id_student ="+id+";");
		//con = DriverManager.getConnection(url, username, password);
		//st = (Statement) con.createStatement();
		//ResultSet res = st.executeQuery("Select * from student;");
		//do
		//{
			//number++;
			//st.executeUpdate("update student set id_student= "+number+";");
		//}while(res.next());
		
	}
	
}
