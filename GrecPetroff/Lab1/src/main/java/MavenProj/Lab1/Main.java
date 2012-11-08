package MavenProj.Lab1;

public class Main {
	public static void main(String args[]){
	 StudentDAO studentDAO = new StudentDAO("students", "student");
     studentDAO.connect();
     studentDAO.listStudents();
	}

}
