package com.example.jdbcExample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;

public class ConnectionPool extends Thread {

	private LinkedList<Connection> available = null;
	private LinkedList<Connection> used = null;

	private String host = null;
	private String username = null;
	private String password = null;
	private String db = null;
	private static String driver = "org.postgresql.Driver";
	private int maxConnections = 10;
	private int port = 5432;

	/**
	 * Loads driver and writes connection info into private fields
	 */
	public ConnectionPool(String host, int port, String db, String username,
			String password) {

		try {

			this.host = host;
			this.username = username;
			this.password = password;
			this.db = db;
			this.port = port;
			Class.forName(this.driver);
			this.available = new LinkedList<Connection>();
			this.used = new LinkedList<Connection>();

		} catch (ClassNotFoundException e) {

			System.err.println(e.getMessage());

		}
	}

	/**
	 * Uses Driver manager to create a conection to DB host
	 * 
	 * @return new connection or null, when some error occurs
	 */
	private Connection getConnection() {

		try {
			return DriverManager.getConnection("jdbc:postgresql://" + host
					+ ":" + port + "/" + db, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public Connection connect() throws SQLException, NullPointerException {

		Connection con = null;
		if (available.size() == 0) {

			con = this.getConnection();
			if (con != null)
				used.add(con);
			else
				throw new NullPointerException();

		} else {

			con = this.available.getLast();
			available.remove(con);
			used.add(con);

		}

		return con;

	}

	/**
	 * Closes an used connection and makes it available
	 */
	public void disconnect(Connection con) throws SQLException {

		used.remove(con);
		con.close();
		available.add(con);

	}

	/**
	 * Closes all used conections clears the lists of used and unused connection
	 */
	@Override
	protected void finalize() throws Throwable {

		super.finalize();

		for (Connection i : used)
			i.close();
		used.clear();
		available.clear();
	}

	/**
	 * Removes unused connections when the limit of connections is reached
	 */
	@Override
	public void run() {

		while (true) {
			synchronized (this) {

				while ((available.size() + used.size()) > maxConnections) {
					Connection con = available.getLast();
					available.removeLast();
					try {
						con.close();
					} catch (SQLException e) {
						System.err.println(e.getMessage());
					}
				}

			}
		}

	}

}
