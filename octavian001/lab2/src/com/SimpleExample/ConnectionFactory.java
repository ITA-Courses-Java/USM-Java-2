package com.SimpleExample;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	String driverName = "com.mysql.jdbc.Driver";
	String connURL = "jdbc:mysql://localhost/testing";
	String user = "root";
	String password = "qwerty";

	private static ConnectionFactory connFactory = null;

	private ConnectionFactory() {
		try {
			Class.forName(driverName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() throws Exception {
		Connection conn = DriverManager.getConnection(connURL, user, password);
		return conn;
	}

	public static ConnectionFactory newConnection() {
		if (connFactory == null) {
			connFactory = new ConnectionFactory();
		}
		return connFactory;
	}

	public static Connection ConnectDB() throws Exception {
		Connection conn = newConnection().getConnection();
		return conn;
	}

}
