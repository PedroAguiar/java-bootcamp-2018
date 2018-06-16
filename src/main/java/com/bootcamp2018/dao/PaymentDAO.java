package com.bootcamp2018.dao;

import com.bootcamp2018.db.DBConnection;
import com.bootcamp2018.dto.OrderDTO;
import com.bootcamp2018.dto.PaymentDTO;

import com.bootcamp2018.model.Payment;

import java.sql.*;


public class PaymentDAO {

    public Payment createPayment(PaymentDTO payment) {
        try(Connection con = DBConnection.getInstance().getDataSource().getConnection()) {
            PreparedStatement pstmt;
            pstmt = con.prepareStatement("INSERT INTO payment (idClient, amount) VALUES (?,?)",Statement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1, payment.getIdClient());
            pstmt.setDouble(2, payment.getPayment().getAmount());
            pstmt.executeUpdate();
            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                payment.getPayment().setId(rs.getInt(1));
                OrderDAO od = new OrderDAO();
                od.createOrder(new OrderDTO(payment.getPayment().getId(),payment.getPayment().getOrder()));
            } else {
                payment = new PaymentDTO();
            }
            pstmt.close();
        } catch (Exception e){
            payment = new PaymentDTO();
        }
        return payment.getPayment();
    }
}
