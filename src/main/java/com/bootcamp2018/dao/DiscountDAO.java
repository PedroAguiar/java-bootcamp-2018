package com.bootcamp2018.dao;

import com.bootcamp2018.db.DBConnection;
import com.bootcamp2018.model.Discount;
import com.bootcamp2018.model.Item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DiscountDAO {


    public Discount createDiscount(Discount discount) {
        try (Connection con = DBConnection.getInstance().getDataSource().getConnection()) {
            PreparedStatement pstmt;
            pstmt = con.prepareStatement("INSERT INTO discount (idItem, quantity, price) VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1, discount.getItem().getId());
            pstmt.setInt(2, discount.getQuantity());
            pstmt.setDouble(3, discount.getPrice());

            pstmt.executeUpdate();
            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                discount.setId(rs.getInt(1));
            } else {
                discount = new Discount();
            }
            pstmt.close();
        } catch (Exception e) {

        }

        return discount;
    }

}
