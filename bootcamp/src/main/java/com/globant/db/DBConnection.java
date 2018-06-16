package com.globant.db;
import java.sql.*;


public class DBConnection {

        private static final String USER_NAME = "root";
        private static final String PASSWORD = "Batata+2018*";
        private static final String DB_CONNECTION_STRING = "jdbc:mysql://localhost:3306/shoppingcart";
        private static DBConnection instance;

        private static Connection connection;

        private DBConnection() throws SQLException {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                this.connection = DriverManager.getConnection(DB_CONNECTION_STRING, USER_NAME , PASSWORD);
            } catch (Exception ex) {
                System.out.println("Database Connection Creation Failed : " + ex.getMessage());
            }
        }

        public Connection getConnection() throws SQLException {
            System.out.println("Connected to database");
            return this.connection;
        }

        public static DBConnection getInstance() throws SQLException {
            if (instance == null) {
                instance = new DBConnection();
            } else if (instance.getConnection().isClosed()) {
                instance = new DBConnection();
            }
            return instance;
        }
    }



