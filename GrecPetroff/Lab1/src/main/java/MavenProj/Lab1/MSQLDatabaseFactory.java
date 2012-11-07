package MavenProj.Lab1;
import java.sql.*;




public class MSQLDatabaseFactory {



    public static Connection connect( String user, String password) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/students", user, password);
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void closeConnection(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }
}

