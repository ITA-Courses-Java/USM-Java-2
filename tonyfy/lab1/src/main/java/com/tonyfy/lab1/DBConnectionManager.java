package com.tonyfy.lab1;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class DBConnectionManager {

    Connection connection;

    String host;
    String name;
    String user;
    String password;

    public DBConnectionManager(String host,
                               String name,
                               String user,
                               String password) {
        this.host = host;
        this.name = name;
        this.user = user;
        this.password = password;
    }

    public abstract void connect() throws SQLException;

    public void disconnect() throws SQLException {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();

            throw e;
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
