package MavenProj.Lab1;
import java.sql.*;


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

    public void setConnection(java.sql.Connection connect) {
        this.connection = connect;
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    public void connect() {
        this.setConnection(MSQLDatabaseFactory.connect("root", "2hungry"));
        if (this.getConnection() == null) {
            System.err.println("Unable to make connection to database " + this.getDatabaseName());
        }
    }




    public void listStudents() {
        if (this.getConnection() != null) {
            try {
                Statement statement = this.getConnection().createStatement();
                ResultSet resultSet = statement.executeQuery("select * from " + this.getTableName());
                ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
                int numberOfColumns = resultSetMetaData.getColumnCount();
              
                for (int i = 1; i <= numberOfColumns; i++) {
                    System.out.printf("%-10s", resultSetMetaData.getColumnName(i));
                }
                System.out.println();

             
                while (resultSet.next()) {
                    System.out.println(new Student((Integer) resultSet.getObject("ID"), (String) resultSet.getObject("first_name"), (String) resultSet.getObject("lastname")));
                }

               
                resultSet.close();
                statement.close();

               
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    protected void finalize() throws Throwable {
        try {
           
            if (this.getConnection() != null) {
                this.getConnection().close();
            }
        } finally {
            super.finalize();
        }
    }
}