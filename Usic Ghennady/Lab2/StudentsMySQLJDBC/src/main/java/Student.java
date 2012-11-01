/**
 * Created with IntelliJ IDEA.
 * User: Ghennady
 * Date: 10/31/12
 * Time: 5:26 PM
 */

/**
 * Class representing logical structure
 * of table student in MySQL database students
 */
public class Student {
    private Integer ID;
    private String firstName;
    private String lastName;

    public Student(Integer ID, String firstName, String lastName) {
        this.setID(ID);
        this.setFirstName(firstName);
        this.setLastName(lastName);
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String toString() {
        return String.format("%-10d%-10s%-10s", this.getID(), this.getFirstName(), this.getLastName());
    }
}
