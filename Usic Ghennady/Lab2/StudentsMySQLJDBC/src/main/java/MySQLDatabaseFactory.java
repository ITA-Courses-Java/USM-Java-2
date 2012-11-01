import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: Ghennady
 * Date: 10/31/12
 * Time: 6:04 PM
 */

/**
 * Class for establishing and managing connection
 * to MySQL database.
 */
public class MySQLDatabaseFactory {
    /**
     * Function that transforms userprovided databaseURL
     * into valid databaseURL for MySQL JDBC driver.
     *
     * @param databaseURL
     * @return changed databaseURL
     */
    private String validateDatabaseURL(String databaseURL) {
        String returnString = null;

        if (databaseURL.matches("jdbc:mysql://localhost/.*")) {
            returnString = databaseURL;
        } else if (databaseURL.matches("^localhost/.*")) {
            returnString = "jdbc:mysql://" + databaseURL;
        }

        return returnString;
    }

    /**
     * Function, that establishes connection to MySQL database
     *
     * @param databaseURL
     * @param user
     * @param password
     * @return established connection or null
     */
    public static Connection connect(String databaseURL, String user, String password) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(new MySQLDatabaseFactory().validateDatabaseURL(databaseURL), user, password);
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
