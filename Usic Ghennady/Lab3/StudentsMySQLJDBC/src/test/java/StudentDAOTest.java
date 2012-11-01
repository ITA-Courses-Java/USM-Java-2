import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class StudentDAOTest {
    private StudentDAO studentDAO;

    @Before
    public void init(){

        this.studentDAO = new StudentDAO("students", "student","root","Minamino7");
    }

    @Test
    public void testAddStudent() throws Exception {
        Student student = new Student("Ghennady", "Usic");
        student = studentDAO.addStudent(student);
        assertEquals(Integer.class,student.getID().getClass());
        assertTrue(student.getID() >= 0);
    }
}
