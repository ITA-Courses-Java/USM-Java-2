import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: Ghennady
 * Date: 10/31/12
 * Time: 5:51 PM
 */
public class Main {

    public static void main(String[] argv) {
        StudentDAO studentDAO = new StudentDAO("students", "student","root","Minamino7");
        studentDAO.connect();
        System.out.println(studentDAO.listStudents());
        Student student = new Student("Ghennady", "Usic");
        System.out.println(student);
        try {
            student = studentDAO.addStudent(student);
            System.out.println(student);
        } catch (SQLException e) {
            e.printStackTrace();

        }

        studentDAO.deleteStudent(student.getID());
    }
}
