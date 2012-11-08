import java.sql.Connection;
import java.sql.DriverManager;


public class ConnectionFactory {
	String driverName = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost/testing";
	String user = "root";
	String pass = "test";
	
	public static ConnectionFactory connf;
	
	private ConnectionFactory() {
		try {
			Class.forName(driverName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() throws Exception {
		Connection conn = DriverManager.getConnection(url, user, pass);
		return conn;
	}

	public static ConnectionFactory newConnection() {
		if (connf == null) {
			connf = new ConnectionFactory();
		}
		return connf;
	}

	public static Connection ConnectDB() throws Exception {
		Connection conn = newConnection().getConnection();
		return conn;
	}

}
