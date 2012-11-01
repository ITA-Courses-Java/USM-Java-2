import java.sql.*;

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
    private Connection connection;

    public StudentDAO(String databaseName, String tableName) {
        this.setDatabaseName(databaseName);
        this.setTableName(tableName);
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
        this.setConnection(MySQLDatabaseFactory.connect("localhost/" + this.getDatabaseName(), "root", "Minamino7"));
        if (this.getConnection() == null) {
            System.err.println("Unable to make connection to database " + this.getDatabaseName());
        }
    }

    /**
     * Function that prints to System.out
     * every entry in table provided by tableName
     * in database provided by databaseName.
     */
    public void listStudents() {
        if (this.getConnection() != null) {
            try {
                Statement statement = this.getConnection().createStatement();
                ResultSet resultSet = statement.executeQuery("select * from " + this.getTableName());
                ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
                int numberOfColumns = resultSetMetaData.getColumnCount();
                // Displaying table's head
                /*----------------------------------------------------------------*/
                for (int i = 1; i <= numberOfColumns; i++) {
                    System.out.printf("%-10s", resultSetMetaData.getColumnName(i));
                }
                System.out.println();
                /*----------------------------------------------------------------*/

                // Displaying table's entries
                /*----------------------------------------------*/
                while (resultSet.next()) {
                    System.out.println(new Student((Integer) resultSet.getObject("ID"), (String) resultSet.getObject("firstName"), (String) resultSet.getObject("lastName")));
                }
                /*-----------------------------------------------*/

                // Closing statement and resultSet
                resultSet.close();
                statement.close();

                /*
                If you want, you may close connection
                 */
                //MySQLDatabaseFactory.closeConnection(this.getConnection());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    protected void finalize() throws Throwable {
        try {
            /*
             Connection is closed here, because I think
             that it's not suitable to close it in listStudents() method.
             And if programmer forgets to close connection this lines
             do good job.
             I know that rewriting finalize() method is a bad practice.
              */
            if (this.getConnection() != null) {
                this.getConnection().close();
            }
        } finally {
            super.finalize();
        }
    }
}
