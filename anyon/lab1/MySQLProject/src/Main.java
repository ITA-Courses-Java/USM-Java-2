import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String str;
		BufferedReader bf = new BufferedReader(new InputStreamReader (System.in));
		char answer = 'y';
		int id = 0,nr = 0;
		while (answer == 'y'){
		
		StudentDAO student = new StudentDAO();
		student.listStudents();
		
			student.addStudent(student);
		
		
		System.out.println("how many students you want to delete?:");
		try{
			str = bf.readLine();
			nr=(Integer.decode(str)).intValue();
		}catch(IOException ex){};
		
		for(int i=0;i<nr;i++){
		System.out.println("if you want to delete any student just choose the id:");
		try{
			str = bf.readLine();
			id=(Integer.decode(str)).intValue();
		}catch(IOException ex){};
		student.deleteStudent(id);
		}
		
		System.out.println("Continue ? [y/n]:");
		try{str = bf.readLine();
		answer = str.charAt(0);}
		catch(IOException ex){}
		finally {};
		}
	}

}
