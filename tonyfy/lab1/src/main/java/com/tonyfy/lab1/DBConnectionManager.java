package com.tonyfy.lab1;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class DBConnectionManager {

    Connection connection;

    String host;
    String name;
    String user;
    String password;

    String url;

    public DBConnectionManager(String host,
                               String name,
                               String user,
                               String password) {
        this.host = host;
        this.name = name;
        this.user = user;
        this.password = password;

        formUrl();
    }

    public abstract void formUrl();

    public abstract void connect() throws SQLException;
    public abstract void disconnect();

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

}
