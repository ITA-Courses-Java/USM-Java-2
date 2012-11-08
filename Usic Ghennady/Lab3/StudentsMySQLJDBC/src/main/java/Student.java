/**
 * Created with IntelliJ IDEA.
 * User: Ghennady
 * Date: 10/31/12
 * Time: 5:26 PM
 */

import java.util.Random;

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

    /**
     * Class Student constructor.
     * ID is filled with random negative integer number
     * in order to ommit NULLPointerException using such an instance
     * further.
     * @param firstName
     * @param lastName
     */
    public Student(String firstName, String lastName) {
        this.setID(0 - new Random().nextInt());
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
