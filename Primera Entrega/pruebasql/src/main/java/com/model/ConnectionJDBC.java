package com.model;

import java.sql.*;
import java.sql.SQLException;

public class ConnectionJDBC {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/mydb?useSSL=false";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASS = "admin";

    String url = "jdbc:mysql://localhost:3306/dbprueba?useSSL=false";
    String uname = "root";
    String pass = "admin";

    public static synchronized Connection getConnection() throws SQLException {


        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e){
            System.out.println("Fallo en cargar el driver JDBC");
            e.printStackTrace();
        }


        Connection con =  DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASS);

        return con;


    }

    public static void close(ResultSet rs) {

        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }


    }

    public static void close(PreparedStatement stmt) {
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }

    public static void close(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }




}
