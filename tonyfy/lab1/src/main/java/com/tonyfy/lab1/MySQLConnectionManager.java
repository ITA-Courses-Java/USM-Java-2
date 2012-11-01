package com.tonyfy.lab1;

import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnectionManager extends DBConnectionManager {

    public MySQLConnectionManager(String host,
                                  String name,
                                  String user,
                                  String password) {
        super(host, name, user, password);
    }

    @Override
    public void connect() throws SQLException {
        connection = DriverManager.getConnection(url, user, password);
    }

    @Override
    public void disconnect() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void formUrl() {
        url = "jdbc:mysql://" + host + "/" + name;
    }

}
