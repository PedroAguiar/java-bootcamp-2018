package com.bootcamp2018.dao;

import com.bootcamp2018.db.DBConnection;
import com.bootcamp2018.dto.OrderDTO;

import com.bootcamp2018.dto.OrderDetailDTO;
import com.bootcamp2018.model.Order;
import com.bootcamp2018.model.OrderDetail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class OrderDAO {
    public Order createOrder(OrderDTO order){
        try(Connection con = DBConnection.getInstance().getDataSource().getConnection()) {

            PreparedStatement pstmt;

            pstmt = con.prepareStatement("INSERT INTO Order (idPayment) VALUES (?)",Statement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1, order.getIdPayment());
            pstmt.executeUpdate();
            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                order.getOrder().setId(rs.getInt(1));
                for (OrderDetail od: order.getOrder().getOrderDetails()
                     ) {
                    OrderDetailDAO odd = new OrderDetailDAO();
                    od = odd.createOrderDetail(new OrderDetailDTO(order.getOrder().getId(),od));
                }
            } else {
                order.setOrder( new Order()) ;
            }
            pstmt.close();
        } catch (Exception e){
            order.setOrder( new Order()) ;
        }
        return order.getOrder();
    }
}
