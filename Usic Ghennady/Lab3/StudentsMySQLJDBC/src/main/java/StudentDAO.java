import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Ghennady
 * Date: 10/31/12
 * Time: 5:30 PM
 */

/**
 * Class that is Data Access Object pattern for class Student
 */
public class StudentDAO {
    private String databaseName;
    private String tableName;
    private String userName;
    private String password;
    private Connection connection;

    /**
     * Method that validates connection and reopens closed or unexisting connection.
     */
    private void validateConnection(){
        // If connection is closed, reopen connection.
        // Note: NullPointerException is catched.
        /*----------------------------------------------------------*/
        try {
            if (this.getConnection().isClosed()) {
                this.setConnection(MySQLDatabaseFactory.connect(this.getDatabaseName(), this.getUserName(), this.getPassword()));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NullPointerException e){
            this.setConnection(MySQLDatabaseFactory.connect(this.getDatabaseName(), this.getUserName(), this.getPassword()));
        }
        /*----------------------------------------------------------*/
    }

    /**
     * Method that performs safe statement,resultSet,connection closing.
     * @param statement
     * @param resultSet
     * @param connection
     */
    private void doClose(Statement statement,ResultSet resultSet,Connection connection){
        try {
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NullPointerException e){

        }
        try {
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {

        }
        MySQLDatabaseFactory.closeConnection(connection);
    }


    public StudentDAO(String databaseName, String tableName, String userName, String password) {
        this.setDatabaseName(databaseName);
        this.setTableName(tableName);
        this.setUserName(userName);
        this.setPassword(password);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    public void connect() {
        this.setConnection(MySQLDatabaseFactory.connect("localhost/" + this.getDatabaseName(), userName, password));
        if (this.getConnection() == null) {
            System.err.println("Unable to make connection to database " + this.getDatabaseName());
        }
    }

    /**
     * Function returning list of all students as
     * List<Student> from table provided by tableName
     * in database provided by databaseName.
     * Remember to check that List<Student> length is not 0
     * in methods that envoke this method.
     */
    public List<Student> listStudents() {
        List<Student> studentList = new ArrayList<Student>();

        this.validateConnection();

        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = this.getConnection().createStatement();
            resultSet = statement.executeQuery("select * from " + this.getTableName());

            // Collecting table entries.
            /*----------------------------------------------*/
            while (resultSet.next()) {
                studentList.add(new Student((Integer) resultSet.getObject("ID"), (String) resultSet.getObject("firstName"), (String) resultSet.getObject("lastName")));
            }
            /*-----------------------------------------------*/
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.doClose(statement,resultSet,this.getConnection());
        }

        return studentList;
    }

    /**
     * Method that finds ID of object Student student
     * with provided firstName and lastName.
     * @param student with negative ID,firstName,lastName.
     * @return  student with valid ID,the same firstName & lastName.
     * @throws SQLException when no entries where found with message "No elements found"
     * and "More than one element found" when more than one ID was found.
     */
    public Student addStudent(Student student) throws SQLException{
        this.validateConnection();

        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = this.getConnection().createStatement();
            resultSet = statement.executeQuery(
                    "select count(*),ID from " + this.getTableName()
                    + " where firstName='" + student.getFirstName() + "'" + "AND "
                    + " lastName='" + student.getLastName() + "'" + ";"
            );

            Integer entriesCount;
            // Checking that at least one row was returned.
            /*----------------------------------------------------*/
            if(resultSet.next()) {
                entriesCount = resultSet.getInt("count(*)");
            } else {
                throw new SQLException("No elements found");
            }

            if(entriesCount == 0){
                throw new SQLException("No elements found");
            }
            /*----------------------------------------------------*/

            // If more than one row were returned.
            if(entriesCount > 1){
                throw new SQLException("More than one element found");
            }

            // If everything is ok.
            student.setID(resultSet.getInt("ID"));


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.doClose(statement,resultSet,this.getConnection());
        }
        return student;
    }

    /**
     * Method, that deletes student whos ID is equal to provided ID.
     * Note: Method prints to System.out the result of its work:
     * "Row is deleted." or "Row is not deleted.".
     * @param ID  student's ID
     */
    public void deleteStudent(int ID){
        this.validateConnection();

        Statement statement = null;
        try {
            statement = this.getConnection().createStatement();

            int removalResult = statement.executeUpdate(
                    "delete from " + this.getTableName()
                    + " where ID=" + ID
                    + ";"
            );

            if(removalResult == 1) {
                System.out.println("Row is deleted.");
            }
            else{
                System.out.println("Row is not deleted.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.doClose(statement,null,this.getConnection());
        }
    }
}
