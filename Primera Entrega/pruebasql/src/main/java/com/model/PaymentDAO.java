package com.model;

import java.sql.*;

public class PaymentDAO {

    private static final String SQL_INSERT = "INSERT INTO payment(amount,idClient) VALUES(?,?)";
    private static final String SQL_SELECT = "SELECT max(idPayment) FROM payment";


    public static int insertPayment(float amount, int id) throws Exception {

        Connection conn = ConnectionJDBC.getConnection();
        int idPayment = -1;

        PreparedStatement stmt = conn.prepareStatement(SQL_INSERT);

        int index = 1;
        stmt.setFloat(index++,amount);
        stmt.setInt(index, id);


        System.out.println("Adding Payment to DB...");

        stmt.executeUpdate();// this returns an int with the number of modified records

        stmt = conn.prepareStatement(SQL_SELECT);
        ResultSet rs = stmt.executeQuery();

        rs.next();
        idPayment = rs.getInt(1);


        ConnectionJDBC.close(stmt);
        ConnectionJDBC.close(conn);

        return idPayment;

    }
}
