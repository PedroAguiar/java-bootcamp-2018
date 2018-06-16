package com.bootcamp2018.dao;

import com.bootcamp2018.db.DBConnection;
import com.bootcamp2018.dto.OrderDetailDTO;
import com.bootcamp2018.dto.PaymentDTO;
import com.bootcamp2018.model.OrderDetail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class OrderDetailDAO {

    public OrderDetail createOrderDetail(OrderDetailDTO orderDetail){
        try(Connection con = DBConnection.getInstance().getDataSource().getConnection()) {

            PreparedStatement pstmt;

            pstmt = con.prepareStatement("INSERT INTO OrderDetail (idItem,idOrder,quantity, price) VALUES (?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1, orderDetail.getOrderDetail().getItem().getId());
            pstmt.setInt(2, orderDetail.getIdOrder());
            pstmt.setInt(2, orderDetail.getOrderDetail().getQuantity());
            pstmt.setDouble(2, orderDetail.getOrderDetail().getPrice());
            pstmt.executeUpdate();
            ResultSet rs = pstmt.getGeneratedKeys();
            if (!rs.next())  {
                orderDetail.setOrderDetail( new OrderDetail()) ;
            }
            pstmt.close();
        } catch (Exception e){
            orderDetail.setOrderDetail( new OrderDetail()) ;
        }
        return orderDetail.getOrderDetail();
    }

}
