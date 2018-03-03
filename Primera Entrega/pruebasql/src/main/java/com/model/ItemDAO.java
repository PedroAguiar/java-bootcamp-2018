package com.model;

import java.sql.*;

import java.util.ArrayList;

public class ItemDAO {

    private final String SQL_SELECT = "SELECT * FROM item";


    public ArrayList<Item> getItems() throws Exception {

        Connection conn = ConnectionJDBC.getConnection();
        ArrayList<Item> items = new ArrayList<Item>();


        PreparedStatement stmt = conn.prepareStatement(SQL_SELECT);
        ResultSet rs = stmt.executeQuery();


        while (rs.next()) {

            int idItem = rs.getInt(1);
            String name = rs.getString(2);
            float price = rs.getFloat(3);

            Item  it = new Item(idItem,name,price);

            items.add(it);




        }

        ConnectionJDBC.close(rs);
        ConnectionJDBC.close(stmt);
        ConnectionJDBC.close(conn);


        return items;


    }

}
