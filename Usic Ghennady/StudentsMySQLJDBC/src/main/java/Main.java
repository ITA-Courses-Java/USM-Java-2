/**
 * Created with IntelliJ IDEA.
 * User: Ghennady
 * Date: 10/31/12
 * Time: 5:51 PM
 */
public class Main {
    public static void main(String[] argv) {
        StudentDAO studentDAO = new StudentDAO("students", "student");
        studentDAO.connect();
        studentDAO.listStudents();
    }
}
