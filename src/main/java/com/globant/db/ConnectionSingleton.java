package com.globant.db;


import com.globant.config.ConnectionProperties;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionSingleton {

    private static ConnectionSingleton instance;
    private Connection connection;

    private ConnectionSingleton() throws SQLException {
        try {
            ConnectionProperties connectionProperties = ConnectionProperties.getInstance();
            String url = connectionProperties.getDatabaseUrl();
            String userName = connectionProperties.getDatabaseUserName();
            String password = connectionProperties.getDatabasePassword();
            Class.forName("com.mysql.jdbc.Driver");
            this.connection = DriverManager.getConnection(url, userName, password);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException();
        }
    }

    public Connection getConnection() throws SQLException {
        return this.connection == null || this.connection.isClosed() ? ConnectionSingleton.getInstance().connection : this.connection;
    }

    public static ConnectionSingleton getInstance() throws SQLException {
        return instance == null ? new ConnectionSingleton() : instance;
    }

}
