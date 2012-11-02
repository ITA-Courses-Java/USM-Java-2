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
        connection = DriverManager
                .getConnection("jdbc:mysql://" + host + "/" + name,
                               user,
                               password);
    }

}
