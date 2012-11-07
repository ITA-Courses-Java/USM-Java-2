package MavenProj.Lab1;

public class Student {
    private Integer Id;
    private String firstName;
    private String lastName;

    public Student(Integer id, String first_name, String lastname) {
        Id=id;
        firstName = first_name;
        lastName =lastname;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
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
        return String.format("%-10d%-10s%-10s", this.getId(), this.getFirstName(), this.getLastName());
    }
}
