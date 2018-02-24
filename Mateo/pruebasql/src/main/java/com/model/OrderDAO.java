package com.model;

import java.sql.*;


public class OrderDAO {

    private static final String SQL_INSERT = "INSERT INTO paymentdetails(idPayment,idItem) VALUES (?,?)";

    public static void insertPaymentDetails(int idPayment, int idItem) throws Exception {

        Connection conn = ConnectionJDBC.getConnection();


        PreparedStatement stmt = conn.prepareStatement(SQL_INSERT);

        int index = 1;
        stmt.setInt(index++,idPayment);
        stmt.setInt(index, idItem);

        stmt.executeUpdate();

        ConnectionJDBC.close(stmt);
        ConnectionJDBC.close(conn);


    }


}
